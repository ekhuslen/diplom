package com.example.gymnasticsScoringSystem.repository;


import com.example.gymnasticsScoringSystem.entity.db.Athlete;
import com.example.gymnasticsScoringSystem.entity.db.CompJudge;
import com.example.gymnasticsScoringSystem.entity.db.CompType;
import com.example.gymnasticsScoringSystem.entity.db.Score;
import com.example.gymnasticsScoringSystem.entity.dto.ScoreDto;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Long> {

    Optional<Score> findByAthleteAndCompTypeAndCompJudge(Athlete athlete, CompType compType, CompJudge judge);

    @Query(value = "SELECT s FROM Score s WHERE s.athlete.id = :athleteId AND s.judge.id = :judgeId AND s.compType.id = :compTypeId", nativeQuery = true)
    Score findScore(Long athleteId, Long judgeId, Long compTypeId);


    @Query("SELECT s FROM Score s WHERE s.athlete.id = :athleteId AND s.compJudge.id = :judgeId AND s.compType.id = :compTypeId")
    Score findByAthleteIdAndJudgeIdAndCompTypeId(
            @Param("athleteId") Long athleteId,
            @Param("judgeId") Long judgeId,
            @Param("compTypeId") Long compTypeId
    );

    @Query(value = "SELECT \n" +
            "                ct.id AS comp_type_id,\n" +
            "                a.id AS athlete_id,\n" +
            "                a.ath_code AS athlete_code,\n" +
            "                a.name AS athlete_name,\n" +
            "                ct.cat_type_code AS category_type,\n" +
            "                cj.judge_type,\n" +
            "                AVG(s.points) AS average_earnings\n" +
            "            FROMs\n" +
            "                score s\n" +
            "            INNER JOIN athlete a ON a.id = s.athlete_id\n" +
            "            INNER JOIN comp_judge cj ON cj.id = s.comp_judge_id\n" +
            "            INNER JOIN comp_type ct ON ct.id = s.comp_type_id\n" +
            "            GROUP BYs\n" +
            "                ct.id,s\n" +
            "                a.id,s\n" +
            "                a.ath_code,s\n" +
            "                a.name,s\n" +
            "                ct.cat_type_code,s\n" +
            "                cj.judge_type\n" +
            "            ORDER BYs\n" +
            "                ct.id,s\n" +
            "                a.id,s\n" +
            "                cj.judge_type", nativeQuery = true)
    List<ScoreDto.JudgeDto> findJudgeScores();

    @Query(value = " SELECT \n" +
            "    ct.id AS comp_type_id,\n" +
            "    ct.comp_id,\n" +
            "    a.id AS athlete_id,\n" +
            "    a.ath_code AS athlete_code,\n" +
            "    a.name AS athlete_name,\n" +
            "    cat_type.code AS category_type_name,\n" +
            "    cat_type.category_code AS category_name,\n" +
            "    AVG(CASE WHEN cj.judge_type != 'torguuli' THEN s.points END) \n" +
            "        - COALESCE(SUM(CASE WHEN cj.judge_type = 'torguuli' THEN s.points END), 0) AS adjusted_average_score\n" +
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
            "    a.ath_code,\n" +
            "    a.name,\n" +
            "    cat_type.code,\n" +
            "    cat_type.category_code \n" +
            "ORDER BY \n" +
            "    ct.id, \n" +
            "    ct.comp_id,\n" +
            "    a.id;\n" +
            "\n" +
            "select * from category_type ct", nativeQuery = true)
    List<ScoreDto.CatTypeDto> findCatTypeScores();


    @Query(value = "SELECT \n" +
            "    ct.comp_id AS competition_id,\n" +
            "    a.id AS athlete_id,\n" +
            "    a.ath_code AS athlete_code,\n" +
            "    a.name AS athlete_name,\n" +
            "    AVG(CASE WHEN cj.judge_type != 'torguuli' THEN s.points END) \n" +
            "        - COALESCE(SUM(CASE WHEN cj.judge_type = 'torguuli' THEN s.points END), 0) AS adjusted_average_score\n" +
            "FROM \n" +
            "    score s\n" +
            "INNER JOIN athlete a ON a.id = s.athlete_id\n" +
            "INNER JOIN comp_judge cj ON cj.id = s.comp_judge_id\n" +
            "INNER JOIN comp_type ct ON ct.id = s.comp_type_id\n" +
            "WHERE \n" +
            "    cj.judge_type != 'torguuli' OR cj.judge_type IS NULL\n" +
            "GROUP BY \n" +
            "    ct.comp_id,\n" +
            "    a.id,\n" +
            "    a.ath_code,\n" +
            "    a.name\n" +
            "ORDER BY \n" +
            "    ct.comp_id,\n" +
            "    a.id", nativeQuery = true)
    List<ScoreDto.CompDto> findCompScores();

}

