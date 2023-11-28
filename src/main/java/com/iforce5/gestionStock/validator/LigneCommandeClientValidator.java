package com.iforce5.gestionStock.validator;

import com.iforce5.gestionStock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO to be implemented
public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veillez renseigner le code de la commande client");
            errors.add("Veillez renseigner la date de la commande du client");
            errors.add("Veillez selectionner un client");
            return errors;
        }

        return errors;
    }
}
