package com.task.manager.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String username;
    private String registrar;

    // No need to manually write getters, setters, toString(), equals(), and hashCode() methods
}
