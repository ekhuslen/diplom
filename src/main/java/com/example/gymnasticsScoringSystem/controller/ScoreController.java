package com.example.gymnasticsScoringSystem.controller;

import com.example.gymnasticsScoringSystem.CoreException;
import com.example.gymnasticsScoringSystem.entity.dto.ScoreDto;
import com.example.gymnasticsScoringSystem.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/judgeTypeScore")
    public ResponseEntity<?> getAllJudgeScores(@RequestParam String judgeType) {
        try {
            List<Map<String, Object>> scores = scoreService.judgeScore(judgeType);
            if (scores.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(scores);
        } catch (CoreException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching judge scores: " + e.getMessage());
        }
    }

    @GetMapping("/catTypeScore")
    public ResponseEntity<?> getAllCatTypeScores(@RequestParam String catType) {
        try {
            List<Map<String, Object>> scores = scoreService.catTypeScore(catType);
            if (scores.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(scores);
        } catch (CoreException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching judge scores: " + e.getMessage());
        }
    }

    @GetMapping("/compScore")
    public ResponseEntity<?> getAllCompScores(@RequestParam String cat) {
        try {
            List<Map<String, Object>> scores = scoreService.compScore(cat);
            if (scores.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(scores);
        } catch (CoreException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching judge scores: " + e.getMessage());
        }
    }

//    @GetMapping("/catTypeScore")
//    public List<ScoreDto.CatTypeDto> getAllCatTypeScores() {
//        return scoreService.getCatTypeScores();
//    }
//
//    @GetMapping("/compScore")
//    public List<ScoreDto.CompDto> getAllCompScores() {
//        return scoreService.getCompScores();
//    }

}
