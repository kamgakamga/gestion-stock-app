package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.FournisseurDto;

public class FournisseurValidator {

	public static List<String> validate(FournisseurDto dto) {
		List<String> errors= new ArrayList<>();
		 if(dto==null) {
			 errors.add("veillez renseigner le nom du fournisseur");
			 errors.add("veillez renseigner le prenom du fournisseur");
			 errors.add("veillez renseigner l'adresse du fournisseur");
			 errors.add("veillez renseigner l'email du fournisseur");
			 return errors;
		 }
		 
		 
		 if (!StringUtils.hasLength(dto.getNom())) {
			 errors.add("veillez renseigner le nom du fournisseur"); 
		 }
		 if (!StringUtils.hasLength(dto.getPrenom())) {
			 errors.add("veillez renseigner le prenom du fournisseur"); 
		 }
		 if (!StringUtils.hasLength(dto.getEmail())) {
			 errors.add("veillez renseigner l'email du fournisseur"); 
		 }
		 if (dto.getNumTel()==null) {
			 errors.add("veillez renseigner le numeros de telephone du fournisseur"); 
		 }
		 if (dto.getAdresseDto() == null) {
			 errors.add("veillez renseigner l'adresse du fournisseur"); 
		 }else {
			 if (!StringUtils.hasLength(dto.getAdresseDto().getAdresse1()) ) {
				 errors.add("le champs 'adresse 1' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(dto.getAdresseDto().getCodePostale()) ) {
				 errors.add("le champs 'code postale' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(dto.getAdresseDto().getVille()) ) {
				 errors.add("le champs 'ville' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(dto.getAdresseDto().getPays()) ) {
				 errors.add("le champs 'Pays' est obligatoire"); 
			 }
		 }
		 
		return errors;
}
}
