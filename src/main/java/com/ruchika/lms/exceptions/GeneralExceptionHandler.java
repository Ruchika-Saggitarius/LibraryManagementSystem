package com.ruchika.lms.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GeneralExceptionHandler  extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> badRequestExceptionHandler(BadRequestException exception) {
        return new ResponseEntity<ApiError>(new ApiError("Bad request", exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiError> unauthorizedExceptionHandler(UnauthorizedException exception) {
        return new ResponseEntity<ApiError>(new ApiError("Unauthorized", exception.getMessage()), HttpStatus.UNAUTHORIZED);
    }
    
}
