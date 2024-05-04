package com.task.manager.entities.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum TaskStatus {
    TODO, IN_PROGRESS, DONE;

    private TaskStatus() {
    }

    public static List<String> literals() {
        List<String> literals = new ArrayList<>();

        for (TaskStatus status : values()) {
            literals.add(status.name());
        }
        Collections.sort(literals);

        return literals;
    }

    public static TaskStatus fromString(String literal) {

        if (literal == null) {
            return null;
        }

        for (TaskStatus status : TaskStatus.values()) {
            if (status.name().equalsIgnoreCase(literal)) {
                return status;
            }
        }

        return null;
    }

}
