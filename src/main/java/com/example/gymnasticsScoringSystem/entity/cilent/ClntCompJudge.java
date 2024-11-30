package com.example.gymnasticsScoringSystem.entity.cilent;

import com.example.gymnasticsScoringSystem.entity.db.Competition;
import com.example.gymnasticsScoringSystem.entity.db.Judge;
import com.example.gymnasticsScoringSystem.enums.JudgeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClntCompJudge {
    private Long id;
    private Competition competition;
    private Judge judge;
    private JudgeType judgeType;
}
