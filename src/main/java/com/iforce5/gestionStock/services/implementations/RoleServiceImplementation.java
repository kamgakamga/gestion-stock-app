package com.iforce5.gestionStock.services.implementations;

import com.iforce5.gestionStock.dto.RolesDto;
import com.iforce5.gestionStock.exceptions.EntityNotFoundException;
import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import com.iforce5.gestionStock.models.Roles;
import com.iforce5.gestionStock.repositories.RolesRepository;
import com.iforce5.gestionStock.services.interfaces.RoleService;
import com.iforce5.gestionStock.validator.RolesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleServiceImplementation implements RoleService {

    private final RolesRepository rolesRepository;

    public RoleServiceImplementation(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public RolesDto saveRole(RolesDto rolesDto) {
        Roles roleToSave = null;
        Roles savedRole = null;

        List<String> errors = RolesValidator.validate(rolesDto);
        if (!errors.isEmpty()){
            log.error("Role not found {}", rolesDto);
            return  null;
        }
        // Cas de la modification du role
        if(Objects.nonNull(rolesDto.getId()) && rolesDto.getId()  > 0  ){
            Roles roleToUpdate = rolesRepository.findById(rolesDto.getId()).orElseThrow(
                    ()-> new EntityNotFoundException("Aucun Role trouvé avec l'id: "+rolesDto.getId(), ErrosCodes.ROLE_NOT_FOUND));
            log.info("Le Role a modifier est {} ", roleToUpdate);

            roleToSave = RolesDto.buildUpdateRole(rolesDto, roleToUpdate );
        }else {
            roleToSave = RolesDto.buildRolesFromRoleDto(rolesDto);
        }
        savedRole = rolesRepository.save(roleToSave);
        log.info("Role sauvegardé avec success {} ", savedRole);
        return RolesDto.fromEntity(savedRole) ;
    }

    @Override
    public RolesDto findRoleById(Integer roleId) {
        if(Objects.isNull(roleId)){
            log.error(" Role ID is null");
            return  null;
        }
        Roles roles = rolesRepository.findById(roleId).orElseThrow( ()-> new EntityNotFoundException("Aucun Role trouvé avec l'id ="+roleId, ErrosCodes.ROLE_NOT_FOUND));
        return RolesDto.fromEntity(roles) ;
    }

    @Override
    public List<RolesDto> getAllRole() {
        return rolesRepository.findAll().stream()
                .map(RolesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(Integer roleId) {
        if(Objects.isNull(roleId)){
            log.error(" Role ID is null");
            return;
        }
        rolesRepository.deleteById(roleId);
    }
}
