package com.iforce5.gestionStock.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Client;
import com.iforce5.gestionStock.models.CommandeClient;
import com.iforce5.gestionStock.models.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommandeClientDto {

	private Integer id;
	
	private String code;
	
	private Date dateCommande;
	
	@JsonIgnore
	private ClientDto clientDto;
	
	@JsonIgnore
	private List<LigneCommandeClientDto> ligneCommandeClientDto;

	
	public CommandeClientDto fromEntity(CommandeClient commandeClient) {
		if(commandeClient == null) {
			return null;
		}
		return CommandeClientDto.builder()
				.id(commandeClient.getId())
				.code(commandeClient.getCode())
				.dateCommande(commandeClient.getDateCommande())
				.build();
	}
	

	public CommandeClient toDto(CommandeClientDto commandeClientDto) {
		if(commandeClientDto == null) {
			return null;
		}
		CommandeClient commandeClient = new CommandeClient();
				    
		commandeClient.setId(commandeClientDto.getId());
		commandeClient.setCode(commandeClientDto.getCode());
		commandeClient.setDateCommande(commandeClient.getDateCommande());
		
	
				    return commandeClient;
	}
	
}
