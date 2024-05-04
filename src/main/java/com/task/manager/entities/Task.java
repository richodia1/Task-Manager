package com.task.manager.entities;

import com.task.manager.entities.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 70)
    private String title;

    @NotBlank
    @Size(max = 70)
    private String description;

    @NotNull
    private LocalDateTime dueDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser createdBy;

    @NotNull
    private Instant lastModifiedDate;

    @NotNull
    private Instant dateCreated;

    @PrePersist
    protected void onCreate() {
        this.dateCreated = Instant.now();
        this.lastModifiedDate = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedDate = Instant.now();
    }
}
