package com.example.gymnasticsScoringSystem.controller;

import com.example.gymnasticsScoringSystem.entity.db.User;
import com.example.gymnasticsScoringSystem.entity.dto.UserRegRequest;
import com.example.gymnasticsScoringSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegRequest request) throws Exception {
        User newUser = userService.registerUser(request);
        return ResponseEntity.ok(newUser);
    }
}
