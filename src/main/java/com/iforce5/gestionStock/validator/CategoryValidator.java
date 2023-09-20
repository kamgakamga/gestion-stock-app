package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import com.iforce5.gestionStock.dto.CategoryDto;

public class CategoryValidator {

	public static List<String> validate(CategoryDto categoryDto) {
	List<String> errors= new ArrayList<>();
	 if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
		 errors.add("veillez renseigner le code de la categorie");
	 }	
	return errors;
	}
}
