package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntAthlete;
import jakarta.persistence.Column;
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

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "athlete")
@NoArgsConstructor
@SequenceGenerator(name = "athlete_id_seq", sequenceName = "athlete_id_seq", allocationSize = 1)
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "athlete_id_seq")
    private Long id;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "club_id", nullable = false)
    private Long clubId;

    private String fname;

    private String gender;

    private String register;

    private String name;

    @ManyToOne
    @JoinColumn(name = "comp_type_id", nullable = false)
    private CompType compType;

    public ClntAthlete toClient() {
        ClntAthlete c = new ClntAthlete();
        c.setId(id);
        c.setName(name);
        c.setFname(fname);
        c.setBirthDate(birthDate);
        c.setGender(gender);
        c.setClubId(clubId);
        c.setRegister(register);
        return c;
    }
}
