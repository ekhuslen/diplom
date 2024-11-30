package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntScore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
@Table(name = "score")
@NoArgsConstructor
@SequenceGenerator(name = "score_id_seq", sequenceName = "score_id_seq", allocationSize = 1)
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_id_seq")
    private Long id;

    @Column(nullable = false)
    private Double points;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "comp_judge_id")
    private CompJudge compJudge;

    @ManyToOne
    @JoinColumn(name = "comp_type_id")
    private CompType compType;


    public ClntScore toClient() {
        ClntScore c = new ClntScore();
        c.setId(id);
        c.setPoints(points);
        c.setAthleteId(athlete.getId());
        c.setCompJudgeId(compJudge.getId());
        c.setCompTypeId(compType.getId());
        return c;
    }

}
