package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findCategoryByCode(String categoryCode);
}
