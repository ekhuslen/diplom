package com.example.gymnasticsScoringSystem.service;

import com.example.gymnasticsScoringSystem.CoreDataTableBase;
import com.example.gymnasticsScoringSystem.entity.db.Score;
import com.example.gymnasticsScoringSystem.repository.AthleteRepo;
import com.example.gymnasticsScoringSystem.repository.CategoryRepo;
import com.example.gymnasticsScoringSystem.repository.JudgeRepo;
import com.example.gymnasticsScoringSystem.repository.ScoreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepo scoreRepo;
    private final AthleteRepo athleteRepo;
    private final CategoryRepo categoryTypeRepo;
    private final JudgeRepo judgeRepo;
    private final CoreDataTableBase coreTable;

    public Score findScore(Long athleteId, Long judgeId, Long compTypeId) {
        return scoreRepo.findScore(athleteId, judgeId, compTypeId);
    }

    public void save(Score score) {
        scoreRepo.save(score);
    }

    public List<Map<String, Object>> judgeScore(String judgeType) {

        Map<String, Object> params = new HashMap<>();
        params.put("judgeType", judgeType);

        String query = "SELECT \n" +
                "    ct.id AS comp_type_id,\n" +
                "    a.id AS athlete_id,\n" +
                "    a.name AS athlete_name,\n" +
                "    ct.cat_type_code AS category_type,\n" +
                "    cj.judge_type,\n" +
                "    AVG(s.points) AS average_earnings\n" +
                "FROM \n" +
                "    score s\n" +
                "INNER JOIN athlete a ON a.id = s.athlete_id\n" +
                "INNER JOIN comp_judge cj ON cj.id = s.comp_judge_id\n" +
                "INNER JOIN comp_type ct ON ct.id = s.comp_type_id\n" +
                "GROUP BY \n" +
                "    ct.id, \n" +
                "    a.id, \n" +
                "    a.name, \n" +
                "    ct.cat_type_code, \n" +
                "    cj.judge_type\n" +
                "ORDER BY \n" +
                "    ct.id, \n" +
                "    a.id, \n" +
                "    cj.judge_type;";

        return coreTable.runNativeQuery(query, params);
    }

    public List<Map<String, Object>> catTypeScore(String catType) {

        Map<String, Object> params = new HashMap<>();
        params.put("catType", catType);

        String query = " SELECT \n" +
                "    ct.id AS comp_type_id,\n" +
                "    ct.comp_id,\n" +
                "    a.id AS athlete_id,\n" +
                "    a.name AS athlete_name,\n" +
                "    cat_type.code AS category_type_name,\n" +
                "    cat_type.category_code AS category_name,\n" +
                "    AVG(CASE WHEN cj.judge_type != 'PENALTY' THEN s.points END) \n" +
                "        - COALESCE(SUM(CASE WHEN cj.judge_type = 'PENALTY' THEN s.points END), 0) AS adjusted_average_score\n" +
                "FROM \n" +
                "    score s\n" +
                "INNER JOIN athlete a ON a.id = s.athlete_id\n" +
                "INNER JOIN comp_judge cj ON cj.id = s.comp_judge_id\n" +
                "INNER JOIN comp_type ct ON ct.id = s.comp_type_id\n" +
                "INNER JOIN category_type cat_type ON cat_type.code = ct.cat_type_code\n" +
                "GROUP BY \n" +
                "    ct.id, \n" +
                "    ct.comp_id,\n" +
                "    a.id,\n" +
                "    a.name,\n" +
                "    cat_type.code,\n" +
                "    cat_type.category_code \n" +
                "ORDER BY \n" +
                "    ct.id, \n" +
                "    ct.comp_id,\n" +
                "    a.id;\n" +
                "\n" +
                "select * from category_type ct ;";

        return coreTable.runNativeQuery(query, params);
    }

    public List<Map<String, Object>> compScore(String catCode) {

        Map<String, Object> params = new HashMap<>();
        params.put("catCode", catCode);

        String query = "SELECT \n" +
                "    ct.comp_id AS competition_id,\n" +
                "    a.id AS athlete_id,\n" +
                "    a.name AS athlete_name,\n" +
                "    AVG(CASE WHEN cj.judge_type != 'PENALTY' THEN s.points END) \n" +
                "        - COALESCE(SUM(CASE WHEN cj.judge_type = 'PENALTY' THEN s.points END), 0) AS adjusted_average_score\n" +
                "FROM \n" +
                "    score s\n" +
                "INNER JOIN athlete a ON a.id = s.athlete_id\n" +
                "INNER JOIN comp_judge cj ON cj.id = s.comp_judge_id\n" +
                "INNER JOIN comp_type ct ON ct.id = s.comp_type_id\n" +
                "WHERE \n" +
                "    cj.judge_type != 'PENALTY' OR cj.judge_type IS NULL\n" +
                "GROUP BY \n" +
                "    ct.comp_id,\n" +
                "    a.id,\n" +
                "    a.name\n" +
                "ORDER BY \n" +
                "    ct.comp_id,\n" +
                "    a.id;";

        return coreTable.runNativeQuery(query, params);
    }



//    public List<ScoreDto.CatTypeDto> getCatTypeScores() {
//        return scoreRepo.findCatTypeScores();
//    }
//
//    public List<ScoreDto.CompDto> getCompScores() {
//        return scoreRepo.findCompScores();
//    }




}