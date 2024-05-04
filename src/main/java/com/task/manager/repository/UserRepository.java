package com.task.manager.repository;

import com.task.manager.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
    List<AppUser> findByFirstNameOrLastName(String firstName, String lastName);
    // Add more custom query methods as needed

}
