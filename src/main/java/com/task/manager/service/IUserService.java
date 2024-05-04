package com.task.manager.service;


import com.task.manager.dto.CreateUserRequestDTO;
import com.task.manager.dto.UpdateUserRequestDTO;
import com.task.manager.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUserById(Long id);
    Optional<UserDTO> getUserByUsername(String username);
    UserDTO createUser(CreateUserRequestDTO userDTO);
    UserDTO updateUser(Long id, UpdateUserRequestDTO userDTO);
    void deleteUserById(Long id);
}
