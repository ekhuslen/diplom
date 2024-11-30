package com.example.gymnasticsScoringSystem.repository;


import com.example.gymnasticsScoringSystem.entity.db.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepo extends JpaRepository<Competition, Long> {
    List<Competition> findByName(String name);
}
