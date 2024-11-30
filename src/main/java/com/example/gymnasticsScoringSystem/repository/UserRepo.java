package com.example.gymnasticsScoringSystem.repository;

import com.example.gymnasticsScoringSystem.entity.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}