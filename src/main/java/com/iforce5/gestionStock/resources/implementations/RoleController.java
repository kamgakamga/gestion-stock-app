package com.iforce5.gestionStock.resources.implementations;

import com.iforce5.gestionStock.dto.RolesDto;
import com.iforce5.gestionStock.resources.interfaces.RoleApi;
import com.iforce5.gestionStock.services.interfaces.RoleService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController implements RoleApi {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public RolesDto saveRole(RolesDto rolesDto) {
        return roleService.saveRole(rolesDto);
    }

    @Override
    public RolesDto findRoleById(Integer roleId) {
        return roleService.findRoleById(roleId);
    }

    @Override
    public List<RolesDto> getAllRole() {
        return roleService.getAllRole();
    }

    @Override
    public void deleteRole(Integer roleId) {
     roleService.deleteRole(roleId);
    }
}
