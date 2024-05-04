package com.task.manager.dto;

import com.task.manager.entities.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdateTaskRequestDTO {

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskStatus status;


}
