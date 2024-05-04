package com.task.manager.service;

import com.task.manager.dto.CreateUserRequestDTO;
import com.task.manager.dto.UpdateUserRequestDTO;
import com.task.manager.dto.UserDTO;

import com.task.manager.entities.User;
import com.task.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(this::convertToDTO);
    }

    @Override
    public Optional<UserDTO> getUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.map(this::convertToDTO);
    }

    @Override
    public UserDTO createUser(CreateUserRequestDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserRequestDTO userDTO) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setDateOfBirth(userDTO.getDateOfBirth());
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setRegistrar(userDTO.getRegistrar());
            // Update other fields as needed
            User updatedUser = userRepository.save(existingUser);
            return convertToDTO(updatedUser);
        }
        // Alternatively, throw an exception or handle the case differently if user not found
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setUsername(user.getUsername());
        userDTO.setRegistrar(user.getRegistrar());
        return userDTO;
    }

    private User convertToEntity(CreateUserRequestDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRegistrar(userDTO.getRegistrar());
        // Set other fields as needed
        return user;
    }
}
