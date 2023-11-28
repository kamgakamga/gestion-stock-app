package com.iforce5.gestionStock.services.implementations;

import com.iforce5.gestionStock.dto.ArticleDto;
import com.iforce5.gestionStock.exceptions.EntityNotFoundException;
import com.iforce5.gestionStock.exceptions.InvalidEntityException;
import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.repositories.ArticleRepository;
import com.iforce5.gestionStock.services.interfaces.ArticleService;
import com.iforce5.gestionStock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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
        if(articleId == null){
            log.error(" Article ID is null");
            return  null;
        }
     Article article = articleRepository.findById(articleId).orElseThrow( ()-> new EntityNotFoundException("Aucun article trouvé avec l'id ="+articleId, ErrosCodes.ARTICLE_NOT_FOUND));
        return ArticleDto.articleToArticleDto(article) ;
    }

    @Override
    public ArticleDto findByArticleCode(String articleCode) {
        if(!StringUtils.hasLength(articleCode) ){
            log.error(" Article Code is null");
            return  null;
        }
        Article article = articleRepository.findArticleByCodeArticle(articleCode).orElseThrow( ()-> new EntityNotFoundException("Aucun article trouvé avec le code ="+articleCode, ErrosCodes.ARTICLE_NOT_FOUND));
        return ArticleDto.articleToArticleDto(article) ;
    }

    @Override
    public List<ArticleDto> getAllArticle() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::articleToArticleDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(Integer articleId) {
        if(articleId == null){
            log.error(" Article ID is null");
            return;
        }
        articleRepository.deleteById(articleId);
    }
}
