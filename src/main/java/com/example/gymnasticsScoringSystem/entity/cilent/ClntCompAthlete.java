package com.example.gymnasticsScoringSystem.entity.cilent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClntCompAthlete {
    private Long id;
    private Long athleteId;
    private Long compId;
    private String catId;
}
