package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.CommandeClientDto;

public class CommandeClientValidator {

	public static List<String> validate(CommandeClientDto dto) {
		List<String> errors = new ArrayList<>();
		
		if (dto == null) {
			errors.add("Veillez renseigner le code de commande client");
			errors.add("Veillez renseigner la date de commande du client");
			errors.add("Veillez selectionner un client");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veillez renseigner le code de commande client");
		}
		
		if(dto.getDateCommande()==null) {
			errors.add("Veillez renseigner la date de commande du client");
		}
		if(dto.getClientDto()==null) {
			errors.add("Veillez selectionner un client");
		}
		
		return errors;
	}
}
