package com.example.gymnasticsScoringSystem.service;

import com.example.gymnasticsScoringSystem.entity.db.Athlete;
import com.example.gymnasticsScoringSystem.repository.AthleteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoachService {
    private final AthleteRepo athleteRepo;

    public Athlete registerAthlete(Athlete athlete) {
        return athleteRepo.save(athlete);
    }

    public Athlete updateAthlete(Long id, Athlete updatedAthlete) {
        return athleteRepo.findById(id)
                .map(athlete -> {
                    athlete.setName(updatedAthlete.getName());
                    athlete.setClubId(updatedAthlete.getClubId());
                    athlete.setBirthDate(updatedAthlete.getBirthDate());
                    athlete.setGender(updatedAthlete.getGender());
                    return athleteRepo.save(athlete);
                })
                .orElseThrow(() -> new RuntimeException("Athlete not found with ID: " + id));
    }

    public void deleteAthlete(Long id) {
        athleteRepo.deleteById(id);
    }

    public List<Athlete> getAllCAthletes() {
        return athleteRepo.findAll();
    }

    public Optional<Athlete> getAthleteDetails(Long id) {
        return athleteRepo.findById(id);
    }

}
