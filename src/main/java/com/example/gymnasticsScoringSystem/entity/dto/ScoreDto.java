package com.example.gymnasticsScoringSystem.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ScoreDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JudgeDto {
        private Long compTypeId;
        private Long athleteId;
        private String athleteCode;
        private String athleteName;
        private String categoryType;
        private String judgeType;
        private Double averagePoint;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CatTypeDto {
        private Long compTypeId;
        private Long compId;
        private Long athleteId;
        private String athleteCode;
        private String athleteName;
        private String categoryTypeName;
        private String categoryName;
        private Double adjustedAverageScore;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompDto {
        private Long competitionId;
        private Long athleteId;
        private String athleteCode;
        private String athleteName;
        private Double adjustedAverageScore;
    }
}
