package com.iforce5.gestionStock.resources.implementations;

import com.iforce5.gestionStock.dto.ArticleDto;
import com.iforce5.gestionStock.resources.interfaces.ArticleApi;
import com.iforce5.gestionStock.services.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @Override
    public ArticleDto saveArticle(ArticleDto articleDto) {
        return articleService.saveArticle(articleDto);
    }

    @Override
    public ArticleDto findArticleById(Integer articleId) {
        return articleService.findArticleById(articleId);
    }

    @Override
    public ArticleDto findByArticleCode(String articleCode) {
        return articleService.findByArticleCode(articleCode);
    }

    @Override
    public List<ArticleDto> getAllArticle() {
        return articleService.getAllArticle();
    }

    @Override
    public void deleteArticle(Integer articleId) {
       articleService.deleteArticle(articleId);
    }
}
