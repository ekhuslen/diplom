package com.example.gymnasticsScoringSystem.entity.dto;

import com.example.gymnasticsScoringSystem.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReq {
    private String username;
    private String password;
    private Role role;

}
