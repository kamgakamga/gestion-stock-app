package com.iforce5.gestionStock.dto;

import java.time.Instant;

import javax.persistence.Column;

import com.iforce5.gestionStock.models.CommandeClient;
import com.iforce5.gestionStock.models.Vente;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VenteDto {

	private Integer id;
	
	private String code;
	
	private Instant dateVente;
	
	private String commentaire;
	
	
	public VenteDto fromEntity(Vente vente) {
		if(vente == null) {
			return null;
		}
		return VenteDto.builder()
				.id(vente.getId())
				.code(vente.getCode())
				.dateVente(vente.getDateVente())
				.commentaire(vente.getCommentaire())
				.build();
	}
	

	public Vente toDto(VenteDto venteDto) {
		if(venteDto == null) {
			return null;
		}
		Vente vente = new Vente();
				    
		vente.setId(venteDto.getId());
		vente.setCode(venteDto.getCode());
		vente.setDateVente(venteDto.getDateVente());
		vente.setCommentaire(venteDto.getCommentaire());
		
	
				    return vente;
	}
}
