package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.CategoryDto;
import com.iforce5.gestionStock.dto.UtilisateurDto;

public class UtilisateurValidator {

	public static List<String> validate(UtilisateurDto utilisateurDto) {
		List<String> errors= new ArrayList<>();
		 if(Objects.isNull(utilisateurDto)) {
			 errors.add("veillez renseigner le nom de l\'utilisateur");
			 errors.add("veillez renseigner le prenom de l\'utilisateur");
			 errors.add("veillez renseigner l'adresse  de l\'utilisateur");
			 errors.add("veillez renseigner la date de naissance de l\'utilisateur");
			 errors.add("veillez renseigner le mot de passe de l\'utilisateur");
			 errors.add("veillez renseigner l'email de l\'utilisateur");
			 return errors;
		 }
		 
		 
		 if (!StringUtils.hasLength(utilisateurDto.getNom())) {
			 errors.add("veillez renseigner le nom de l\'utilisateur"); 
		 }
		 if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			 errors.add("veillez renseigner le prenom de l\'utilisateur"); 
		 }
		 if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
			 errors.add("veillez renseigner l'email de l\'utilisateur");
		 }
		 if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			 errors.add("veillez renseigner le mot de passe de l\'utilisateur"); 
		 }
		 if (Objects.isNull(utilisateurDto.getDateDeNaissance())) {
			 errors.add("veillez renseigner la date de naissance de l\'utilisateur"); 
		 }
		 if (Objects.isNull(utilisateurDto.getAdresseDto()) ) {
			 errors.add("veillez renseigner l'adresse d\'utilisateur"); 
		 }else {
			 if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getAdresse1()) ) {
				 errors.add("le champs 'adresse 1' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getCodePostale()) ) {
				 errors.add("le champs 'code postale' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getVille()) ) {
				 errors.add("le champs 'ville' est obligatoire"); 
			 }
			 if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getPays()) ) {
				 errors.add("le champs 'Pays' est obligatoire"); 
			 }
		 }
		 
		return errors;
}
} 
