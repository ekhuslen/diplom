package com.example.gymnasticsScoringSystem.entity.cilent;

import com.example.gymnasticsScoringSystem.entity.db.CategoryType;
import com.example.gymnasticsScoringSystem.entity.db.Competition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class ClntCompType {
    private Long id;
    private Competition competition;
    private CategoryType categoryType;
}

