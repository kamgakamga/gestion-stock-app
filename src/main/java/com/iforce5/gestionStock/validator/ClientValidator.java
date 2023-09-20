package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.ClientDto;

public class ClientValidator {

	public static List<String> validate(ClientDto dto) {
		List<String> errors= new ArrayList<>();
		 if(dto==null) {
			 errors.add("veillez renseigner le nom du client");
			 errors.add("veillez renseigner le prenom du client");
			 errors.add("veillez renseigner l'adresse du client");
			 errors.add("veillez renseigner l'email du client");
			 return errors;
		 }

		 if (!StringUtils.hasLength(dto.getNom())) {
			 errors.add("veillez renseigner le nom du client"); 
		 }
		 if (!StringUtils.hasLength(dto.getPrenom())) {
			 errors.add("veillez renseigner le prenom du client"); 
		 }
		 if (!StringUtils.hasLength(dto.getEmail())) {
			 errors.add("veillez renseigner l'email du client"); 
		 }
		 if (Objects.isNull(dto.getNumTel())) {
			 errors.add("veillez renseigner le numeros de telephone du client"); 
		 }
		 if (Objects.isNull(dto.getAdresseDto())) {
			 errors.add("veillez renseigner l'adresse du client"); 
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
