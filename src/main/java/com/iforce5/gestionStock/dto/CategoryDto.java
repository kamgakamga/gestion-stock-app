package com.iforce5.gestionStock.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.models.Category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {

	private Integer id;
	
	private String code;
	
	private String designation;
	
	@JsonIgnore
	private List<ArticleDto> articleDto;
	
	
	
	public static CategoryDto fromEntity(Category category) {
		if(category == null) {
			return null;
		}
		return CategoryDto.builder()
				     .id(category.getId())
				     .code(category.getCode())
				     .designation(category.getDesignation())
				     .build();
	}

	public static Category buildUpdateCategory(CategoryDto categoryDto, Category categoryToUpdate) {
		categoryToUpdate.setCode(categoryDto.getCode());
		categoryToUpdate.setDesignation(categoryDto.getDesignation());
		return  categoryToUpdate;

	}


	public static Category buildCategoryFromCategoryDto(CategoryDto categoryDto) {
		if(categoryDto == null) {
			return null;
		}
		Category category = new Category();
				    
		category.setId(categoryDto.getId());
		            category.setCode(categoryDto.getCode());
				    category.setDesignation(categoryDto.getDesignation());
				     
				    return category;
	}
}
