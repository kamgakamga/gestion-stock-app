package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
