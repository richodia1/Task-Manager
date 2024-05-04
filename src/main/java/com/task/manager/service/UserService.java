package com.task.manager.service;

import com.task.manager.dto.CreateUserRequestDTO;
import com.task.manager.dto.UpdateUserRequestDTO;
import com.task.manager.dto.UserDTO;

import com.task.manager.entities.AppUser;
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
        Optional<AppUser> userOptional = userRepository.findById(id);
        return userOptional.map(this::convertToDTO);
    }

    @Override
    public Optional<UserDTO> getUserByUsername(String username) {
        Optional<AppUser> userOptional = userRepository.findByUsername(username);
        return userOptional.map(this::convertToDTO);
    }

    @Override
    public UserDTO createUser(CreateUserRequestDTO userDTO) {
        AppUser user = convertToEntity(userDTO);
        AppUser savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserRequestDTO userDTO) {
        Optional<AppUser> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            AppUser existingUser = existingUserOptional.get();
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setDateOfBirth(userDTO.getDateOfBirth());
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setRegistrar(userDTO.getRegistrar());
            // Update other fields as needed
            AppUser updatedUser = userRepository.save(existingUser);
            return convertToDTO(updatedUser);
        }
        // Alternatively, throw an exception or handle the case differently if user not found
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(AppUser user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setUsername(user.getUsername());
        userDTO.setRegistrar(user.getRegistrar());
        return userDTO;
    }

    private AppUser convertToEntity(CreateUserRequestDTO userDTO) {
        AppUser user = new AppUser();
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
