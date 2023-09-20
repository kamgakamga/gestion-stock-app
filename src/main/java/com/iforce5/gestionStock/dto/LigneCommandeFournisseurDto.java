package com.iforce5.gestionStock.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.models.CommandeFounisseur;
import com.iforce5.gestionStock.models.LigneCommandeClient;
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

    
    public LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
		if(ligneCommandeFournisseur == null) {
			return null;
		}
		return LigneCommandeFournisseurDto.builder()
				.id(ligneCommandeFournisseur.getId())
				.build();
	}
	

	public LigneCommandeFournisseur toDto(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		if(ligneCommandeFournisseurDto == null) {
			return null;
		}
		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
				    
		ligneCommandeFournisseur.setId(ligneCommandeFournisseur.getId());
		
				    return ligneCommandeFournisseur;
	}
}
