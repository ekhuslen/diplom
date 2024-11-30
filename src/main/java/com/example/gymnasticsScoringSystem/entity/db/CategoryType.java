package com.example.gymnasticsScoringSystem.entity.db;

import com.example.gymnasticsScoringSystem.entity.cilent.ClntCategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category_type")
@NoArgsConstructor
public class CategoryType {
    @Id
    private String code;

    @ManyToOne
    @JoinColumn(name = "category_code", nullable = false)
    private Category categoryCode;

    private String name;

    public ClntCategoryType toClient() {
        ClntCategoryType c = new ClntCategoryType();
        c.setCode(code);
        c.setCategoryCode(categoryCode.getCode());
        c.setName(name);
        return c;
    }
}
