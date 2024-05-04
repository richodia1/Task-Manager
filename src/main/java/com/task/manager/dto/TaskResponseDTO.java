package com.task.manager.dto;

import com.task.manager.entities.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
    private Long createdByUserId;

}
