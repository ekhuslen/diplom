package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntCompetition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "competition")
@NoArgsConstructor
@SequenceGenerator(name = "competition_id_seq", sequenceName = "competition_id_seq", allocationSize = 1)
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_id_seq")
    private Long id;

    private String detail;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "finish_date", nullable = false)
    private LocalDate finishDate;

    private String location;

    private String name;

    public ClntCompetition toClient() {
        ClntCompetition c = new ClntCompetition();
        c.setId(id);
        c.setName(name);
        c.setLocation(location);
        c.setStartDate(startDate);
        c.setFinishDate(finishDate);
        c.setDetail(detail);
        return c;
    }

}