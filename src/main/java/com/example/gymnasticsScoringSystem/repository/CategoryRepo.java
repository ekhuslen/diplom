package com.example.gymnasticsScoringSystem.repository;

import com.example.gymnasticsScoringSystem.entity.db.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
