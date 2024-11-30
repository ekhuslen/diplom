package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntCoach;
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


@Getter
@Setter
@Entity
@Table(name = "coach")
@NoArgsConstructor
@SequenceGenerator(name = "coach_id_seq", sequenceName = "coach_id_seq", allocationSize = 1)
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coach_id_seq")
    private Long id;

    @Column(name = "club_id", nullable = false)
    private Long clubId;

    private String name;

    public ClntCoach toClient() {
        ClntCoach c = new ClntCoach();
        c.setId(id);
        c.setName(name);
        c.setClubId(clubId);
        return c;
    }

}
