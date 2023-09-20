package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.ArticleDto;

public class ArticleValidator {
	
	public static List<String> validate(ArticleDto dto) {
		List<String> errors = new ArrayList<>();
		
		if (dto == null) {
			errors.add("Veillez renseigner le code de l'article");
			errors.add("Veillez renseigner le designation de l'article");
			errors.add("Veillez renseigner le prix unitaire de l'article");
			errors.add("Veillez renseigner le taux TVA de l'article");
			errors.add("Veillez renseigner le prix unitaire TTC de l'article");
			
			return errors;
		}
		if(!StringUtils.hasLength(dto.getCodeArticle())) {
			errors.add("Veillez renseigner le code de l'article");
		}
		if(!StringUtils.hasLength(dto.getDesignation())) {
			errors.add("Veillez renseigner la designation de l'article");
		}
		if(Objects.isNull(dto.getPrixUnitaire())  ) {
			errors.add("Veillez renseigner le prix unitaire de l'article");
		}
		if(dto.getTauxTva() == null) {
			errors.add("Veillez renseigner le Taux TVA de l'article");
		}
		if(dto.getPrixUnitaireTTC()==null) {
			errors.add("Veillez renseigner le prix unitaire ttc de l'article");
		}
		if(dto.getCategory()==null) {
			errors.add("Veillez selectionner la categorie de l'article");
		}
		
		return errors;
	}

}
