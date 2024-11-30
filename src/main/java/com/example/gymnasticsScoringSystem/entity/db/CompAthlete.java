package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntCompAthlete;
import jakarta.persistence.Entity;
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
@Table(name = "comp_athlete")
@NoArgsConstructor
@SequenceGenerator(name = "comp_athlete_id_seq", sequenceName = "comp_athlete_id_seq", allocationSize = 1)
public class CompAthlete {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_athlete_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athleteId;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition compId;

    @ManyToOne
    @JoinColumn(name = "category_code", nullable = false)
    private CategoryType catId;


    public ClntCompAthlete toClient() {
        ClntCompAthlete c = new ClntCompAthlete();
        c.setId(getId());
        c.setAthleteId(athleteId.getId());
        c.setCompId(compId.getId());
        c.setCatId(catId.getCode());
        return c;
    }
}
