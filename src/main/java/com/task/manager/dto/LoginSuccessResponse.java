package com.task.manager.dto;

import lombok.Data;

@Data
public class LoginSuccessResponse {

    private String username;
    private String message;

    public LoginSuccessResponse(String username, String message) {

        this.username = username;
        this.message = message;

    }

}

