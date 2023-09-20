package com.iforce5.gestionStock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.iforce5.gestionStock.dto.RolesDto;

public class RolesValidator {
	
	public static List<String> validate(RolesDto dto) {
		List<String> errors = new ArrayList<>();
		
		if (dto == null) {
			errors.add("Veillez renseigner le nom du role");
			errors.add("Veillez renseigner l'utilisateur du role");
			return errors;
		}
		if(!StringUtils.hasLength(dto.getRoleName())) {
			errors.add("Veillez renseigner nom du role");
		}
		if(dto.getUtilisateurDto()==null) {
			errors.add("Veillez selectionner un utilisateur pour le role");
		}
		
		return errors;
	}


}
