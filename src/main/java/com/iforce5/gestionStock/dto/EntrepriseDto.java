package com.iforce5.gestionStock.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Adresse;
import com.iforce5.gestionStock.models.Client;
import com.iforce5.gestionStock.models.Entreprise;
import com.iforce5.gestionStock.models.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EntrepriseDto {

	private Integer id;
	
 	private String nom;
	
 	private String description;
	
 	private String photo;
	
 	private String email;
	
 	private String codeFiscal;
	
 	private String numTel;
	
 	@JsonIgnore
	private Adresse adresse;
	
 	private String steWeb;
	
 	@JsonIgnore
 	private List<UtilisateurDto> utilisateursDto;

	
 	
 	public EntrepriseDto fromEntity(Entreprise entreprise) {
		if(entreprise == null) {
			return null;
		}
		return EntrepriseDto.builder()
				.id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
				.photo(entreprise.getPhoto())
				.email(entreprise.getEmail())
				.codeFiscal(entreprise.getCodeFiscal())
				.numTel(entreprise.getNumTel())
				.steWeb(entreprise.getSteWeb())
				.build();
	}
	

	public Entreprise toDto(EntrepriseDto entrepriseDto) {
		if(entrepriseDto == null) {
			return null;
		}
		Entreprise entreprise = new Entreprise();
				    
		entreprise.setId(entrepriseDto.getId());
		entreprise.setNom(entrepriseDto.getNom());
		entreprise.setDescription(entrepriseDto.getDescription());
		entreprise.setPhoto(entrepriseDto.getPhoto());
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setNumTel(entrepriseDto.getNumTel());
		entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
		entreprise.setSteWeb(entrepriseDto.getSteWeb());
	
				    return entreprise;
	}
	
}
