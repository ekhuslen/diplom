package com.example.gymnasticsScoringSystem.entity.cilent;

import com.example.gymnasticsScoringSystem.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class ClntUser {
    private Long id;
    private String username;
    private String password;
    private Role role;
}
