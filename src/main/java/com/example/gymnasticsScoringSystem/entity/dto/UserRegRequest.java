package com.example.gymnasticsScoringSystem.entity.dto;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntUser;
import com.example.gymnasticsScoringSystem.entity.db.Coach;
import com.example.gymnasticsScoringSystem.entity.db.Judge;
import com.example.gymnasticsScoringSystem.entity.db.Organizer;
import com.example.gymnasticsScoringSystem.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegRequest {
    private String username;
    private String password;
    private Role role;

    private Coach coach;
    private Organizer organizer;
    private Judge judge;

    public void setRegReq(ClntUser user) {
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setRole(user.getRole());
    }

    public void checkUserRole() throws Exception {
        switch (role) {
            case COACH -> {
                if (coach == null) {
                    throw new Exception("");
                }
            }
            case ORGANIZER -> {

            }
            case JUDGE -> {

            }
        }
    }
}
