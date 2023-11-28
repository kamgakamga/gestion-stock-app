package com.iforce5.gestionStock.resources.interfaces;

import com.iforce5.gestionStock.dto.RolesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.iforce5.gestionStock.utils.Constants.APP_ROOT;

public interface RoleApi {
    @PostMapping(value = APP_ROOT+"/role/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto saveRole(@RequestBody RolesDto rolesDto);

    @GetMapping(value =  "/role/{roleId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto findRoleById(@PathVariable("roleId") Integer roleId);

    @GetMapping(value =  "/role/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<RolesDto> getAllRole();

    @DeleteMapping(value =  "/role/delete/{roleId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteRole(@PathVariable("roleId") Integer roleId);
}
