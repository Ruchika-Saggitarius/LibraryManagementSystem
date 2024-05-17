package com.ruchika.lms.services;

import org.springframework.stereotype.Service;

import com.ruchika.lms.model.User;
import com.ruchika.lms.requests.LoginUserRequest;
import com.ruchika.lms.requests.RegisterUserRequest;
import com.ruchika.lms.requests.ResetPasswordRequest;
import com.ruchika.lms.requests.UpdateEmailRequest;

@Service
public interface IUserService {

    void saveUser(RegisterUserRequest registerUserRequest);

    String loginUser(LoginUserRequest loginUserRequest);

    User getUserProfile(String userId);

    void updateEmailOfUser(String userId, UpdateEmailRequest updateEmailRequest);

    void ResetPasswordOfUser(String userId, ResetPasswordRequest resetPasswordRequest);

    // void ForgotPasswordSendLinkViaEmail(String email);

}
