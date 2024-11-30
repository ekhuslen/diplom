package com.example.gymnasticsScoringSystem.repository;

import com.example.gymnasticsScoringSystem.entity.db.Coach;
import com.example.gymnasticsScoringSystem.entity.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoachRepo extends JpaRepository<Coach, Long> {

}