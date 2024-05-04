package com.task.manager.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUserRequestDTO {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String username;
    private String password;
    private String registrar;

}