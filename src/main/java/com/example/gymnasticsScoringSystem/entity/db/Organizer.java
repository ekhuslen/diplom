package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntOrganizer;
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
@Table(name = "organizer")
@NoArgsConstructor
@SequenceGenerator(name = "organizer_id_seq", sequenceName = "organizer_id_seq", allocationSize = 1)
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizer_id_seq")
    private Long id;

    private String name;


    public ClntOrganizer toClient() {
        ClntOrganizer c = new ClntOrganizer();
        c.setId(id);
        c.setName(name);
        return c;
    }

}

