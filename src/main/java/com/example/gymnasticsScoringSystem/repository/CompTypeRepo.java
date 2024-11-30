package com.example.gymnasticsScoringSystem.repository;

import com.example.gymnasticsScoringSystem.entity.db.CompType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompTypeRepo extends JpaRepository<CompType, Long> {
}
