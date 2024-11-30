package com.example.gymnasticsScoringSystem.repository;

import com.example.gymnasticsScoringSystem.entity.db.Judge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JudgeRepo extends JpaRepository<Judge, Long> { }
