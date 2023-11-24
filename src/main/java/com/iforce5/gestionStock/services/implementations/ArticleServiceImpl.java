package com.iforce5.gestionStock.services.implementations;

import com.iforce5.gestionStock.dto.ArticleDto;
import com.iforce5.gestionStock.exceptions.InvalidEntityException;
import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.repositories.ArticleRepository;
import com.iforce5.gestionStock.services.interfaces.ArticleService;
import com.iforce5.gestionStock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ArticleService")
@Slf4j
public class ArticleServiceImpl  implements ArticleService {

    final private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public ArticleDto saveArticle(ArticleDto articleDto) {

        List<String> errors = ArticleValidator.validate(articleDto);

        if(!errors.isEmpty()){
            log.error("Article is not valid {} ",articleDto);
            throw new InvalidEntityException("L'article n'est pas valide ", ErrosCodes.ARTICLE_INVALID,errors);
        }
        Article articleToSave = ArticleDto.articleDtoToArticle(articleDto);
        Article  articleSaved = articleRepository.save(articleToSave);
        return ArticleDto.articleToArticleDto(articleSaved) ;
    }

    @Override
    public ArticleDto findArticleById(Integer articleId) {
        return null;
    }

    @Override
    public ArticleDto findByArticleCode(String articleCode) {
        return null;
    }

    @Override
    public List<ArticleDto> getAllArticle() {
        return null;
    }

    @Override
    public void deleteArticle(Integer articleId) {

    }
}
