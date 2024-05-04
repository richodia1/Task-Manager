package com.task.manager.dto;

import lombok.Data;

@Data
public class LogOutResponse {

    private String message;

    public LogOutResponse(String message) {
        this.message = message;
    }

}
