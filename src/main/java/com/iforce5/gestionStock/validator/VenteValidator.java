package com.iforce5.gestionStock.validator;

import com.iforce5.gestionStock.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VenteValidator {

    public static List<String> validator(VenteDto venteDto){

        List<String> errors = new ArrayList<>();

        if(Objects.isNull(venteDto)){
            errors.add("Veillez renseigner le code le la vente !");
            errors.add("Veillez renseigner la date de la vente !");
            return errors;
        }
        if(StringUtils.hasLength(venteDto.getCode())){
            errors.add("Veillez renseigner le code de la vente !");
            return errors;
        }
        if(Objects.isNull(venteDto.getDateVente())){
            errors.add("Veillez renseigner la date de la vente !");
            return errors;
        }

        return errors;
    }
}
