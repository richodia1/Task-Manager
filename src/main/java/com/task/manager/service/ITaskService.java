package com.task.manager.service;

import com.task.manager.dto.CreateTaskRequestDTO;
import com.task.manager.dto.TaskDTO;
import com.task.manager.dto.UpdateTaskRequestDTO;
import com.task.manager.entities.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<TaskDTO> getAllTasks();
    Optional<TaskDTO> getTaskById(Long id);
    TaskDTO createTask(CreateTaskRequestDTO taskDTO);
    TaskDTO updateTask(Long id, UpdateTaskRequestDTO taskDTO);
    void deleteTaskById(Long id);
}
