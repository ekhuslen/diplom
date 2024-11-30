package com.example.gymnasticsScoringSystem.entity.cilent;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClntAthlete {
    private Long id;
    private String name;
    private String fname;
    private Date birthDate;
    private String gender;
    private Long clubId;
    private String register;

}
