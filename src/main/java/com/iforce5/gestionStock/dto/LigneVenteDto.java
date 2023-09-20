package com.iforce5.gestionStock.dto;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Entreprise;
import com.iforce5.gestionStock.models.LigneVente;
import com.iforce5.gestionStock.models.Vente;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneVenteDto {

	private Integer id;
	
	@JsonIgnore
	private VenteDto venteDto;
	
	private BigDecimal quantite;
	
	
	public LigneVenteDto fromEntity(LigneVente ligneVente) {
		if(ligneVente == null) {
			return null;
		}
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.quantite(ligneVente.getQuantite())
				.build();
	}
	

	public LigneVente toDto(LigneVenteDto ligneVenteDto) {
		if(ligneVenteDto == null) {
			return null;
		}
		LigneVente ligneVente = new LigneVente();
				    
		ligneVente.setId(ligneVenteDto.getId()); 
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		
	
				    return ligneVente;
	}
	
}
