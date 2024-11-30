package com.example.gymnasticsScoringSystem.service;

import com.example.gymnasticsScoringSystem.entity.db.User;
import com.example.gymnasticsScoringSystem.entity.dto.UserRegRequest;
import com.example.gymnasticsScoringSystem.repository.CoachRepo;
import com.example.gymnasticsScoringSystem.repository.JudgeRepo;
import com.example.gymnasticsScoringSystem.repository.OrganizerRepo;
import com.example.gymnasticsScoringSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CoachRepo coachRepo;
    @Autowired
    private OrganizerRepo organizerRepo;
    @Autowired
    private JudgeRepo judgeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserRegRequest request) throws Exception {

        request.checkUserRole();
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encodedPassword);

        user.setRole(request.getRole());

        switch (request.getRole()) {
            case COACH -> coachRepo.save(request.getCoach());
            case ORGANIZER -> organizerRepo.save(request.getOrganizer());
            case JUDGE -> judgeRepo.save(request.getJudge());
        }

        return userRepo.save(user);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}

