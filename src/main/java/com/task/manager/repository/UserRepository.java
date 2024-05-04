package com.task.manager.repository;

import com.task.manager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    List<User> findByFirstNameOrLastName(String firstName, String lastName);
    // Add more custom query methods as needed

}
