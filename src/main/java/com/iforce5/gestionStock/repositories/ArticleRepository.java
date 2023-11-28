package com.iforce5.gestionStock.repositories;

import com.iforce5.gestionStock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
   Optional<Article> findArticleByCodeArticle (String articleCode);
}
