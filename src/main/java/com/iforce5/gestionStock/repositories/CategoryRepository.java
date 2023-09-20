package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
