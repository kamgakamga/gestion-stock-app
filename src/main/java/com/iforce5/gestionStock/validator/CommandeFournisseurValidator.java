package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.CommandeFournisseurDto;


public class CommandeFournisseurValidator {

	
	public static List<String> validate(CommandeFournisseurDto dto) {
		List<String> errors = new ArrayList<>();
		
		if (dto == null) {
			errors.add("Veillez renseigner le codFournisseure de commande Fournisseur");
			errors.add("Veillez renseigner la date de commande du Fournisseur");
			errors.add("Veillez selectionner un Fournisseur");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veillez renseigner le code de commande Fournisseur");
		}
		
		if(dto.getDateCommande()==null) {
			errors.add("Veillez renseigner la date de commande du Fournisseur");
		}
		if(dto.getFournisseurDto()==null) {
			errors.add("Veillez selectionner un Fournisseur");
		}
		
		return errors;
	}
}
