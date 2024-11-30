package com.example.gymnasticsScoringSystem.service;

import com.example.gymnasticsScoringSystem.entity.db.CompJudge;
import com.example.gymnasticsScoringSystem.entity.db.Competition;
import com.example.gymnasticsScoringSystem.repository.CompJudgeRepo;
import com.example.gymnasticsScoringSystem.repository.CompetitionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerService {

    private final CompetitionRepo competitionRepo;
    private final CompJudgeRepo compJudgeRepo;

    public Competition registerComp(Competition competition) {
        return competitionRepo.save(competition);
    }

    public Competition updateComp(Long id, Competition updatedCompetition) {
        return competitionRepo.findById(id)
                .map(existingCompetition -> {
                    existingCompetition.setName(updatedCompetition.getName());
                    existingCompetition.setLocation(updatedCompetition.getLocation());
                    existingCompetition.setStartDate(updatedCompetition.getStartDate());
                    existingCompetition.setFinishDate(updatedCompetition.getFinishDate());
                    existingCompetition.setDetail(updatedCompetition.getDetail());
                    return competitionRepo.save(existingCompetition);
                })
                .orElseThrow(() -> new RuntimeException("Competition not found with ID: " + id));
    }

    public void deleteComp(Long id) {
        competitionRepo.deleteById(id);
    }

    public List<Competition> getAllComp() {
        return competitionRepo.findAll();
    }

    public CompJudge registerAsJudge(CompJudge compJudge) {
        return compJudgeRepo.save(compJudge);
    }

}
