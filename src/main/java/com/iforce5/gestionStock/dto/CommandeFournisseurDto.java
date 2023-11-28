package com.iforce5.gestionStock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.CommandeFournisseur;

import com.iforce5.gestionStock.models.Fournisseur;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommandeFournisseurDto {

	private Integer id;

	private String code;

	private Instant dateCommande;

	@JsonIgnore
	private FournisseurDto fournisseurDto;

	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDto;



	public static CommandeFournisseurDto commandeFournisseurToCommandeFournisseurDto(CommandeFournisseur commandeFournisseur) {
		if(commandeFournisseur == null) {
			return null;
		}
		return CommandeFournisseurDto.builder()
				.id(commandeFournisseur.getId())
				.code(commandeFournisseur.getCode())
				.dateCommande(commandeFournisseur.getDateCommande())
				.build();
	}


	public static CommandeFournisseur commandeFounisseurDtoToCommandeFounisseur(CommandeFournisseurDto commandeFournisseurDto, Fournisseur fournisseur) {
		if(commandeFournisseurDto == null) {
			return null;
		}
		CommandeFournisseur commandeFournisseur = new CommandeFournisseur();

		commandeFournisseur.setId(commandeFournisseurDto.getId());
		commandeFournisseur.setCode(commandeFournisseurDto.getCode());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		return commandeFournisseur;
	}

}
