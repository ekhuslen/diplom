package com.example.gymnasticsScoringSystem.controller;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntAthlete;
import com.example.gymnasticsScoringSystem.entity.db.Athlete;
import com.example.gymnasticsScoringSystem.entity.db.Competition;
import com.example.gymnasticsScoringSystem.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/registerAthlete")
    public ResponseEntity<Athlete> registerAthlete(@RequestBody Athlete athlete) {
        return ResponseEntity.ok(coachService.registerAthlete(athlete));
    }

    @PostMapping("/updateAthlete")
    public ResponseEntity<Athlete> updateAthlete(@PathVariable Long id, @RequestBody Athlete a) {
        return ResponseEntity.ok(coachService.updateAthlete(id, a));
    }

    @PostMapping("/deleteAthlete")
    public ResponseEntity<String> deleteAthlete(@PathVariable Long id) {
        coachService.deleteAthlete(id);
        return ResponseEntity.ok("Athlete deleted successfully.");
    }

    @GetMapping("/getAllAthletes")
    public ResponseEntity<List<Athlete>> getAllAthletes() {
        return ResponseEntity.ok(coachService.getAllCAthletes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClntAthlete> getAthleteDetails(@PathVariable Long id) {
        Optional<Athlete> athlete = coachService.getAthleteDetails(id);
        if (athlete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(athlete.get().toClient());
    }

}
