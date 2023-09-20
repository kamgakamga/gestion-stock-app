package com.iforce5.gestionStock.dto;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.CommandeClient;
import com.iforce5.gestionStock.models.CommandeFounisseur;
import com.iforce5.gestionStock.models.Fournisseur;
import com.iforce5.gestionStock.models.LigneCommandeFournisseur;

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
	
	@JsonIgnore
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDto;
	
	
	
	public CommandeFournisseurDto fromEntity(CommandeFounisseur commandeFounisseur) {
		if(commandeFounisseur == null) {
			return null;
		}
		return CommandeFournisseurDto.builder()
				.id(commandeFounisseur.getId())
				.code(commandeFounisseur.getCode())
				.dateCommande(commandeFounisseur.getDateCommande())
				.build();
	}
	

	public CommandeFounisseur toDto(CommandeFournisseurDto commandeFournisseurDto) {
		if(commandeFournisseurDto == null) {
			return null;
		}
		CommandeFounisseur commandeFounisseur = new CommandeFounisseur();
				    
		commandeFounisseur.setId(commandeFournisseurDto.getId());
		commandeFounisseur.setCode(commandeFournisseurDto.getCode());
		commandeFounisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		
	
				    return commandeFounisseur;
	}
	
}
