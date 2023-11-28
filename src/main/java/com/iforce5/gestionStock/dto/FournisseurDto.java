package com.iforce5.gestionStock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {

	private Integer id;
	
 	private String nom;
	
 	private String prenom;
	
 	private String photo;
	
 	private String email;
	
 	private String numTel;
	
 	@JsonIgnore
	private AdresseDto adresseDto;
	
	@JsonIgnore
 	private List<CommandeFournisseurDto> commandeFournisseurDto;

	
	public FournisseurDto fromEntity(Fournisseur fournisseur) {
		if(fournisseur == null) {
			return null;
		}
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.photo(fournisseur.getPhoto())
				.email(fournisseur.getEmail())
				.numTel(fournisseur.getNumTel())
				.build();
	}
	

	public Fournisseur toDto(FournisseurDto fournisseurDto) {
		if(fournisseurDto == null) {
			return null;
		}
		Fournisseur fournisseur = new Fournisseur();
				    
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setEmail(fournisseurDto.getEmail());
		fournisseur.setNumTel(fournisseurDto.getNumTel());
	
				    return fournisseur;
	}
	
}
