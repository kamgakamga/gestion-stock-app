package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.ArticleDto;
import com.iforce5.gestionStock.dto.EntrepriseDto;

public class EntrepriseValidator {
	
	public static List<String> validate(EntrepriseDto dto) {
		List<String> errors = new ArrayList<>();
		
		if (dto == null) {
			errors.add("Veillez renseigner le nom de l'entreprise");
			errors.add("Veillez renseigner la description de l'entreprise");
			errors.add("Veillez renseigner l'email de l'entreprise");
			errors.add("Veillez renseigner le code fiscale de l'entreprise");
			errors.add("Veillez renseigner le numeros de telephone de l'entreprise");
			
			return errors;
		}
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Veillez renseigner le nom de l'entrprise");
		}
		if(!StringUtils.hasLength(dto.getDescription())) {
			errors.add("Veillez renseigner la description de l'entrprise");
		}
		if(StringUtils.hasLength(dto.getEmail())) {
			errors.add("Veillez renseigner l'email de l'entreprise");
		}
		if(StringUtils.hasLength(dto.getNumTel())) {
			errors.add("Veillez renseigner le numero de telephone de l'entreprise");
		}
		if(StringUtils.hasLength(dto.getCodeFiscal())) {
			errors.add("Veillez renseigner le code fiscale de l'entreprise");
		}
		if (dto.getAdresse() == null) {
			 errors.add("veillez renseigner l'adresse d\'utilisateur"); 
		 }else {
			 if (!StringUtils.hasLength(dto.getAdresse().getAdresse1()) ) {
				 errors.add("le champs 'adresse 1' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(dto.getAdresse().getCodePostale()) ) {
				 errors.add("le champs 'code postale' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(dto.getAdresse().getVille()) ) {
				 errors.add("le champs 'ville' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(dto.getAdresse().getPays()) ) {
				 errors.add("le champs 'Pays' est obligatoire"); 
			 }
		 }
		
		return errors;
	}


}
