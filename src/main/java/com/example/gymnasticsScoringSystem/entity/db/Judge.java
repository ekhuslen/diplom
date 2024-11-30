package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntJudge;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "judge")
@NoArgsConstructor
@SequenceGenerator(name = "judge_id_seq", sequenceName = "judge_id_seq", allocationSize = 1)
public class Judge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "judge_id_seq")
    private Long id;
    private String name;

    public ClntJudge toClient() {
        ClntJudge c = new ClntJudge();
        c.setId(id);
        c.setName(name);
        return c;
    }

}

