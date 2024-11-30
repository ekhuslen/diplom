package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntCompType;
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
@Table(name = "comp_type")
@NoArgsConstructor
@SequenceGenerator(name = "comp_type_id_seq", sequenceName = "comp_type_id_seq", allocationSize = 1)
public class CompType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_type_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comp_id", nullable = false)
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "cat_type_code", nullable = false)
    private CategoryType categoryType;

    public ClntCompType toClient() {
        ClntCompType c = new ClntCompType();
        c.setId(id);
        c.setCategoryType(categoryType);
        c.setCompetition(competition);
        return c;
    }
}
