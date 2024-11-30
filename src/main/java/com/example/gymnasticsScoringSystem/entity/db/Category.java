package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {
    @Id
    private String code;
    private String name;

    public ClntCategory toClient() {
        ClntCategory c = new ClntCategory();
        c.setCode(code);
        c.setName(name);
        return c;
    }
}
