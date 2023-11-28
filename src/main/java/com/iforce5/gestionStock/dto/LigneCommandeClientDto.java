package com.iforce5.gestionStock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeClientDto {

	private Integer id;
	
	@JsonIgnore
	private ArticleDto articleDto;
	
	@JsonIgnore
	private CommandeClientDto commandeClientDto;
	
	
	public static LigneCommandeClientDto LigneCommandeClientToLigneCommandeClientDto (LigneCommandeClient ligneCommandeClient) {
		if(ligneCommandeClient == null) {
			return null;
		}
		return LigneCommandeClientDto.builder()
				.id(ligneCommandeClient.getId())
				.build();
	}
	

	public static LigneCommandeClient LigneCommandeClientDtoToLigneCommandeClient(LigneCommandeClientDto ligneCommandeClientDto) {
		if(ligneCommandeClientDto == null) {
			return null;
		}
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
				    
		ligneCommandeClient.setId(ligneCommandeClient.getId());
		
				    return ligneCommandeClient;
	}
}
