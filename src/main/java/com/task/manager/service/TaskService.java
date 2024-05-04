package com.task.manager.service;

import com.task.manager.dto.CreateTaskRequestDTO;
import com.task.manager.dto.TaskDTO;
import com.task.manager.dto.UpdateTaskRequestDTO;
import com.task.manager.entities.Task;
import com.task.manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskService implements ITaskService{
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDTO> getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(this::convertToDTO);
    }

    @Override
    public TaskDTO createTask(CreateTaskRequestDTO taskDTO) {
        Task task = convertToEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
    }

    @Override
    public TaskDTO updateTask(Long id, UpdateTaskRequestDTO taskDTO) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setTitle(taskDTO.getTitle());
            existingTask.setDescription(taskDTO.getDescription());
            existingTask.setDueDate(taskDTO.getDueDate());
            existingTask.setStatus(taskDTO.getStatus());
            // Update other fields as needed
            Task updatedTask = taskRepository.save(existingTask);
            return convertToDTO(updatedTask);
        }
        // Alternatively, throw an exception or handle the case differently if task not found
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskDTO convertToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setCreatedByUserId(task.getCreatedBy().getId());
        return taskDTO;
    }

    private Task convertToEntity(CreateTaskRequestDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        // Set other fields as needed
        return task;
    }
}
