package com.example.gymnasticsScoringSystem.service;

import com.example.gymnasticsScoringSystem.entity.db.Athlete;
import com.example.gymnasticsScoringSystem.entity.db.CompAthlete;
import com.example.gymnasticsScoringSystem.entity.db.CompJudge;
import com.example.gymnasticsScoringSystem.entity.db.CompType;
import com.example.gymnasticsScoringSystem.entity.db.Score;
import com.example.gymnasticsScoringSystem.repository.AthleteRepo;
import com.example.gymnasticsScoringSystem.repository.CompAthleteRepo;
import com.example.gymnasticsScoringSystem.repository.CompJudgeRepo;
import com.example.gymnasticsScoringSystem.repository.CompTypeRepo;
import com.example.gymnasticsScoringSystem.repository.ScoreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JudgeService {

    private final AthleteRepo athleteRepo;
    private final ScoreRepo scoreRepo;
    private final CompJudgeRepo compJudgeRepo;
    private final CompAthleteRepo compAthleteRepo;


    public CompAthlete signAthlete(CompAthlete c) {
        return compAthleteRepo.save(c);
    }

//    public Score getScore(Long athleteId, Long typeId, Long judgeId, double point) {
//        Athlete athlete = athleteRepo.findById(athleteId)
//                .orElseThrow(() -> new RuntimeException("Athlete not found with id: " + athleteId));
//
//        CompType compType = compTypeRepo.findById(typeId)
//                .orElseThrow(() -> new RuntimeException("Type not found with id: " + typeId));
//
//        CompJudge judge = compJudgeRepo.findById(judgeId)
//                .orElseThrow(() -> new RuntimeException("Judge not found with id: " + judgeId));
//
//        Optional<Score> existingScore = scoreRepo.findByAthleteAndCompTypeAndCompJudge(athlete, compType, judge);
//
//        if (existingScore.isPresent()) {
//            throw new RuntimeException("This judge has already scored this athlete in this type.");
//        }
//
//        Score score = new Score();
//        score.setAthlete(athlete);
//        score.setCompType(compType);
//        score.setCompJudge(judge);
//        score.setPoints(point);
//
//        return scoreRepo.save(score);
//    }



}
