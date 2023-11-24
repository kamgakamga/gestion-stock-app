package com.iforce5.gestionStock.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Adresse;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.models.Category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {

	private Integer id;
	
	private String codeArticle;
	
	private String designation;
	
	private BigDecimal prixUnitaire;
	
	private BigDecimal tauxTva;
	
	private BigDecimal prixUnitaireTTC;
	
 	private String photo;
	
 	private CategoryDto category; 
 	
 	
 	public static ArticleDto articleToArticleDto(Article article) {
		if(article == null) {
			return null;
		}
		return ArticleDto.builder()
				.id(article.getId())
				.codeArticle(article.getCodeArticle())
				.designation(article.getDesignation())
				.prixUnitaire(article.getPrixUnitaire())
				.tauxTva(article.getTauxTva())
				.prixUnitaireTTC(article.getPrixUnitaireTTC())
				.category(CategoryDto.fromEntity(article.getCategory()))
				.build();
	}
	

	public static Article articleDtoToArticle(ArticleDto articleDto) {
		if(articleDto == null) {
			return null;
		}
		Article article = new Article();
				    
		article.setId(articleDto.getId());
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesignation(articleDto.getDesignation());
		article.setPrixUnitaire(articleDto.getPrixUnitaire());
		article.setTauxTva(articleDto.getTauxTva());
		article.setPrixUnitaireTTC(articleDto.getPrixUnitaireTTC());
		article.setPhoto(articleDto.getPhoto());
				     
		return article;
	}
}
