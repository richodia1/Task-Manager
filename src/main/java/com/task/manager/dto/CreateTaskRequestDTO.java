package com.task.manager.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateTaskRequestDTO {

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Long createdByUserId;

}
