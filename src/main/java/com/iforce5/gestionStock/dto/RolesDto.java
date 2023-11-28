package com.iforce5.gestionStock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iforce5.gestionStock.models.Roles;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

	private Integer id;
	
	private String roleName;

	private String description;

	@JsonIgnore
	private UtilisateurDto utilisateurDto;

    public static Roles buildUpdateRole(RolesDto rolesDto, Roles roleToUpdate) {

		roleToUpdate.setRoleName(rolesDto.getRoleName());
		roleToUpdate.setRoleDescription(rolesDto.getDescription());
		return roleToUpdate;
    }

	public  static RolesDto fromEntity(Roles roles) {
		if(roles == null) {
			return null;
		}
		return RolesDto.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.build();
	}
	

	public static Roles buildRolesFromRoleDto(RolesDto rolesDto) {
		if(rolesDto == null) {
			return null;
		}
		Roles roles = new Roles();
				    
		rolesDto.setId(rolesDto.getId()); 
		rolesDto.setRoleName(rolesDto.getRoleName());
		
		
	
				    return roles;
	}
	
	
}
