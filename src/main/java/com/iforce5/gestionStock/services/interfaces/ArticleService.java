package com.iforce5.gestionStock.services.interfaces;

import com.iforce5.gestionStock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto saveArticle(ArticleDto articleDto);
    ArticleDto findArticleById(Long articleId);
    ArticleDto findByArticleCode(String articleCode);
    List<ArticleDto> getAllArticle();
    void deleteArticle(Long articleId);
}
