package com.task.manager.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdateUserRequestDTO {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String username;
    private String registrar;

}
