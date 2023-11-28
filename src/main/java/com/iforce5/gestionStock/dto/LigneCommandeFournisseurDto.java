package com.iforce5.gestionStock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.iforce5.gestionStock.models.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeFournisseurDto {
  
	private Integer id;
	
	@JsonIgnore
    private ArticleDto articleDto;
	 
    @JsonIgnore
    private CommandeFournisseurDto commandeFournisseurDto;


	public static LigneCommandeFournisseurDto commandeFounisseurToCommandeFounisseurDto(LigneCommandeFournisseur ligneCommandeFournisseur) {
		if(ligneCommandeFournisseur == null) {
			return null;
		}
		return LigneCommandeFournisseurDto.builder()
				.id(ligneCommandeFournisseur.getId())
				.build();
	}
	

	public static LigneCommandeFournisseur commandeFounisseurDtoToCommandeFounisseur(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		if(ligneCommandeFournisseurDto == null) {
			return null;
		}
		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
				    
		ligneCommandeFournisseur.setId(ligneCommandeFournisseur.getId());
		
				    return ligneCommandeFournisseur;
	}
}
