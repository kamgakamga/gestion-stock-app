package com.iforce5.gestionStock.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.MouvementStock;
import com.iforce5.gestionStock.models.Roles;
import com.iforce5.gestionStock.models.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

	private Integer id;
	
	private String roleName;
	 
	@JsonIgnore
	private UtilisateurDto utilisateurDto;
	
	
	public RolesDto fromEntity(Roles roles) {
		if(roles == null) {
			return null;
		}
		return RolesDto.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.build();
	}
	

	public Roles toDto(RolesDto rolesDto) {
		if(rolesDto == null) {
			return null;
		}
		Roles roles = new Roles();
				    
		rolesDto.setId(rolesDto.getId()); 
		rolesDto.setRoleName(rolesDto.getRoleName());
		
		
	
				    return roles;
	}
	
	
}
