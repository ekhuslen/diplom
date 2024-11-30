package com.example.gymnasticsScoringSystem.controller;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntScore;
import com.example.gymnasticsScoringSystem.entity.db.CompAthlete;
import com.example.gymnasticsScoringSystem.entity.db.Score;
import com.example.gymnasticsScoringSystem.repository.AthleteRepo;
import com.example.gymnasticsScoringSystem.repository.CompJudgeRepo;
import com.example.gymnasticsScoringSystem.repository.CompTypeRepo;
import com.example.gymnasticsScoringSystem.service.JudgeService;
import com.example.gymnasticsScoringSystem.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/judge")
public class JudgeController {

    @Autowired
    private JudgeService judgeService;

    @Autowired
    private AthleteRepo athleteRepo;

    @Autowired
    private CompJudgeRepo judgeRepo;

    @Autowired
    private CompTypeRepo compTypeRepo;


    @Autowired
    private ScoreService scoreService;


    @PostMapping("/score/add-or-update")
    public ResponseEntity<String> addOrUpdateScore(@Valid @RequestBody ClntScore scoreDto) throws Exception {

        var a = athleteRepo.findById(scoreDto.getAthleteId());
        if (a.isEmpty()) {
            throw new Exception("Ath not found");
        }

        var j = judgeRepo.findById(scoreDto.getCompJudgeId());
        if (j.isEmpty()) {
            throw new Exception("Judge not found");
        }

        var c = compTypeRepo.findById(scoreDto.getCompTypeId());
        if (c.isEmpty()) {
            throw new Exception("CompType not found");
        }

        Score score = scoreService.findScore(scoreDto.getAthleteId(), scoreDto.getCompJudgeId(), scoreDto.getCompTypeId());


        if (score == null) {
            score = new Score();
            score.setAthlete(a.get());
            score.setCompJudge(j.get());
            score.setCompType(c.get());
        }

        score.setPoints(scoreDto.getPoints());

        scoreService.save(score);
        return ResponseEntity.ok("Score added/updated successfully");
    }

    @PostMapping("/sign/athlete")
    public ResponseEntity<CompAthlete> signAthlete(@RequestBody CompAthlete j) {
        return ResponseEntity.ok(judgeService.signAthlete(j));
    }


}
