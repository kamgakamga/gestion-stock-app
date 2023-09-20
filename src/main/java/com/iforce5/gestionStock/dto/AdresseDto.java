package com.iforce5.gestionStock.dto;

import javax.persistence.Column;

import com.iforce5.gestionStock.models.Adresse;
import com.iforce5.gestionStock.models.Category;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class AdresseDto {
	
	private String adresse1;
	
	private String adresse2;
	
	private String ville;
	
	private String codePostale;
	
	private String pays;

	// Cette methode converti un objet AdresseDTO en un objet Adresse
	public AdresseDto fromEntity(Adresse adresse) {
		if(adresse == null) {
			return null;
		}
		return AdresseDto.builder()
				.adresse1(adresse.getAdresse1())
				.adresse2(adresse.getAdresse2())
				.codePostale(adresse.getCodePostale())
				.pays(adresse.getPays())
				.ville(adresse.getVille())
				.build();
	}
	

	// Cette methode converti un objet AdresseDTO en un objet Adresse
	public Adresse toDto(AdresseDto adresseDto) {
		if(adresseDto == null) {
			return null;
		}
		Adresse adresse = new Adresse();
				    
		adresse.setAdresse1(adresseDto.getAdresse1());
		adresse.setAdresse2(adresseDto.getAdresse2());
		adresse.setVille(adresseDto.getVille());
		adresse.setCodePostale(adresseDto.getCodePostale());
		adresse.setPays(adresseDto.getPays());
		return adresse;
	}
}
