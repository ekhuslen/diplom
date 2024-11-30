package com.example.gymnasticsScoringSystem.repository;


import com.example.gymnasticsScoringSystem.entity.db.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AthleteRepo extends JpaRepository<Athlete, Long> {

}
