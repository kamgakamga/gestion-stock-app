package com.iforce5.gestionStock.resources.interfaces;

import com.iforce5.gestionStock.dto.ArticleDto;
import com.iforce5.gestionStock.services.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.iforce5.gestionStock.utils.Constants.APP_ROOT;


public interface ArticleApi {

   // @Qualifier("ArticleService")
   // final public ArticleService articleService;

   // public ArticleApi(ArticleService articleService) {
       // this.articleService = articleService;
 //   }

    @PostMapping(value =  "/article/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto saveArticle(@RequestBody ArticleDto articleDto);

    @GetMapping(value =  "/article/{articleId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findArticleById(@PathVariable("articleId") Long articleId);

    @GetMapping(value =  "/article/{codeArticle}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByArticleCode(@PathVariable("codeArticle") String articleCode);

    @GetMapping(value =  "/article/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> getAllArticle();

    @DeleteMapping(value =  "/article/delete/{articleId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteArticle(@PathVariable("articleId") Long articleId);
}
