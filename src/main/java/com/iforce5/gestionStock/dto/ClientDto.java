package com.iforce5.gestionStock.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Adresse;
import com.iforce5.gestionStock.models.Article;
import com.iforce5.gestionStock.models.Client;
import com.iforce5.gestionStock.models.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {

	private Integer id;
	
 	private String nom;

 	private String prenom;
	
 	private String photo;
	
 	private String email;

 	private String numTel;
	
 	@JsonIgnore
	private AdresseDto adresseDto;
	
 	@JsonIgnore
 	private List<CommandeClientDto> commandeClientDto;

 	
 	public ClientDto fromEntity(Client client) {
		if(client == null) {
			return null;
		}
		return ClientDto.builder()
				.id(client.getId())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.photo(client.getPhoto())
				.email(client.getEmail())
				.numTel(client.getNumTel())
				.build();
	}
	

	public Client toDto(ClientDto clientDto) {
		if(clientDto == null) {
			return null;
		}
		Client client = new Client();
				    
		client.setId(clientDto.getId());
		client.setNom(clientDto.getNom());
		client.setPrenom(clientDto.getPrenom());
		client.setPhoto(clientDto.getPhoto());
		client.setEmail(clientDto.getEmail());
		client.setNumTel(clientDto.getNumTel());
	
				    return client;
	}
	
}
