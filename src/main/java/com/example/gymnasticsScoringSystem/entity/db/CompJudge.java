package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntCompJudge;
import com.example.gymnasticsScoringSystem.enums.JudgeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comp_judge")
@NoArgsConstructor
@SequenceGenerator(name = "comp_judge_id_seq", sequenceName = "comp_judge_id_seq", allocationSize = 1)
public class CompJudge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_judge_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comp_id", nullable = false)
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "judge_id", nullable = false)
    private Judge judge;

    @Enumerated(EnumType.STRING)
    @Column(name = "judge_type", nullable = false)
    private JudgeType judgeType;

    public ClntCompJudge toClient() {
        ClntCompJudge c = new ClntCompJudge();
        c.setId(id);
        c.setJudge(judge);
        c.setCompetition(competition);
        c.setJudgeType(judgeType);
        return c;
    }

}
