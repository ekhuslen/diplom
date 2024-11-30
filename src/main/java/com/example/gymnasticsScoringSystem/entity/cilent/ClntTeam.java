package com.example.gymnasticsScoringSystem.entity.cilent;

import com.example.gymnasticsScoringSystem.entity.db.Athlete;
import com.example.gymnasticsScoringSystem.entity.db.CompType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClntTeam {
    private Long id;
    private Long clubId;
    private String name;
    private Athlete athlete;
    private CompType compType;

}
