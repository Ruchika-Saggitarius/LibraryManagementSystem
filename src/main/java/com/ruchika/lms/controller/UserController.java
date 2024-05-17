package com.ruchika.lms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruchika.lms.model.User;

import com.ruchika.lms.requests.LoginUserRequest;
import com.ruchika.lms.requests.RegisterUserRequest;
import com.ruchika.lms.requests.ResetPasswordRequest;
import com.ruchika.lms.requests.UpdateEmailRequest;
import com.ruchika.lms.responses.GetUserProfileResponse;
import com.ruchika.lms.responses.LoginResponse;
import com.ruchika.lms.services.IUserService;
import com.ruchika.lms.services.JwtService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    JwtService jwtService;

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        userService.saveUser(registerUserRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginUserRequest loginUserRequest){
        String jwtToken = userService.loginUser(loginUserRequest);
        return ResponseEntity.ok(new LoginResponse(jwtToken)); 
    }

    @GetMapping("/user/profile")
    public ResponseEntity<GetUserProfileResponse> getUserProfile(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = ((User) auth.getPrincipal()).getUserId();
        User user = userService.getUserProfile(userId);
        return ResponseEntity.ok(new GetUserProfileResponse(user.getEmail(),user.getDisplayName(), user.getRole()));        
    }

    @PostMapping("/user/email")
    public void updateEmailOfUser(HttpServletRequest request, @RequestBody UpdateEmailRequest updateEmailRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = ((User) auth.getPrincipal()).getUserId();
        userService.updateEmailOfUser(userId, updateEmailRequest);
    }

    @PostMapping("/user/reset-password")
    public void resetPasswordOfUser(HttpServletRequest request, @RequestBody ResetPasswordRequest resetPasswordRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = ((User) auth.getPrincipal()).getUserId();
        userService.ResetPasswordOfUser(userId, resetPasswordRequest);
    }
}
