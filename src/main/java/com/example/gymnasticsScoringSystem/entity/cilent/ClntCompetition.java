package com.example.gymnasticsScoringSystem.entity.cilent;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClntCompetition {
    private Long id;
    private String detail;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String location;
    private String name;
}
