package com.example.gymnasticsScoringSystem.controller;

import com.example.gymnasticsScoringSystem.entity.db.CompJudge;
import com.example.gymnasticsScoringSystem.entity.db.Competition;
import com.example.gymnasticsScoringSystem.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @PostMapping("/competition")
    public ResponseEntity<Competition> registerCompetition(@RequestBody Competition c) {
        return ResponseEntity.ok(organizerService.registerComp(c));
    }

    @PostMapping("/updateCompetition")
    public ResponseEntity<Competition> updateComp(@PathVariable Long id, @RequestBody Competition competition) {
        return ResponseEntity.ok(organizerService.updateComp(id, competition));
    }

    @PostMapping("/deleteCompetition")
    public ResponseEntity<String> deleteComp(@RequestBody Long id) {
        organizerService.deleteComp(id);
        return ResponseEntity.ok("Competition deleted successfully.");
    }

    @GetMapping("/getAllCompetitions")
    public ResponseEntity<List<Competition>> getAllCompetitions() {
        return ResponseEntity.ok(organizerService.getAllComp());
    }

    @PostMapping("/assignJudgeType")
    public ResponseEntity<CompJudge> assignJudgeType(@RequestBody CompJudge j) {
        return ResponseEntity.ok(organizerService.registerAsJudge(j));
    }
}
