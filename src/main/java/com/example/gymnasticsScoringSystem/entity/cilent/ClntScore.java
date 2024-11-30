package com.example.gymnasticsScoringSystem.entity.cilent;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClntScore {
    private Long id;
    private double points;
    private Long athleteId;
    private Long compJudgeId;
    private Long compTypeId;

}

