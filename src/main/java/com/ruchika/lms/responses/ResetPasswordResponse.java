package com.ruchika.lms.responses;

public class ResetPasswordResponse {

    private String message;

    public ResetPasswordResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
