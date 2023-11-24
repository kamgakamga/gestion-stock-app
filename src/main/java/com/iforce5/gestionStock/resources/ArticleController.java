package com.iforce5.gestionStock.resources;

import com.iforce5.gestionStock.services.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Qualifier("ArticleService")
    final public ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
}
