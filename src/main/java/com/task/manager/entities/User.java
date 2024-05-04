package com.task.manager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotBlank
    @Size(max = 130)
    private String password;

    // Assuming registrar represents the user who registered the account
    @NotBlank
    @Size(max = 30)
    private String registrar;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();

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


