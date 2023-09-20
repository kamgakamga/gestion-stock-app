package com.iforce5.gestionStock.dto;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Adresse;
import com.iforce5.gestionStock.models.Client;
import com.iforce5.gestionStock.models.Entreprise;
import com.iforce5.gestionStock.models.Roles;
import com.iforce5.gestionStock.models.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDto {

	private Integer id;
	
 	private String nom;

 	private String prenom;
	
 	private String photo;

 	private String email;

 	private String numTel;
 	
	private String motDePasse;
	
 	private Instant dateDeNaissance;
	
 	@JsonIgnore
	private AdresseDto adresseDto;
    
	@JsonIgnore
 	private EntrepriseDto entrepriseDto;
	
    @JsonIgnore
 	private List<RolesDto> rolesDto;
	
 	
 	public UtilisateurDto fromEntity(Utilisateur utilisateur) {
		if(utilisateur == null) {
			return null;
		}
		return UtilisateurDto.builder()
				.id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.photo(utilisateur.getPhoto())
				.email(utilisateur.getEmail())
				.numTel(utilisateur.getNumTel())
				.motDePasse(utilisateur.getMotDePasse())
				.dateDeNaissance(utilisateur.getDateDeNaissance())
				.build();
	}
	

	public Utilisateur toDto(UtilisateurDto utilisateurDto) {
		if(utilisateurDto == null) {
			return null;
		}
		Utilisateur utilisateur = new Utilisateur();
				    
		utilisateur.setId(utilisateurDto.getId());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setPhoto(utilisateurDto.getPhoto());
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setNumTel(utilisateurDto.getNumTel());
		utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
		utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
	
				    return utilisateur;
	}
}
