package com.iforce5.gestionStock.services.interfaces;

import com.iforce5.gestionStock.dto.RolesDto;

import java.util.List;

public interface RoleService {
    RolesDto saveRole(RolesDto rolesDto);
    RolesDto findRoleById(Integer roleId);
    List<RolesDto> getAllRole();
    void deleteRole(Integer roleId);
}
