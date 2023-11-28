package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.CommandeClientDto;

public class CommandeClientValidator {

	public static List<String> validate(CommandeClientDto dto) {
		List<String> errors = new ArrayList<>();
		
		if (dto == null) {
			errors.add("Veillez renseigner le code de la commande client");
			errors.add("Veillez renseigner la date de la commande du client");
			errors.add("Veillez selectionner un client");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veillez renseigner le code de commande client");
		}
		
		if(Objects.isNull(dto.getDateCommande())) {
			errors.add("Veillez renseigner la date de commande du client");
		}
		if(Objects.isNull(dto.getClientDto())) {
			errors.add("Veillez selectionner un client");
		}

		if(Objects.nonNull(dto.getClientDto()) && Objects.isNull(dto.getClientDto().getId()) ) {
			errors.add("Veillez selectionner un client");
		}
		if(Objects.isNull(dto.getLigneCommandeClientDto())) {
			errors.add("Veillez renseigner les lignes de commande de cette commande.");
		}

		if(dto.getLigneCommandeClientDto().isEmpty()) {
			errors.add("Une commande doit avoir au moins une lignes de commande.");
		}
		
		return errors;
	}
}
