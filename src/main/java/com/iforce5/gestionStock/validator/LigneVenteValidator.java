package com.iforce5.gestionStock.validator;

import com.iforce5.gestionStock.dto.LigneVenteDto;
import com.iforce5.gestionStock.dto.MouvementStockDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LigneVenteValidator {

    public static List<String> validator(LigneVenteDto ligneVenteDto){

        List<String> errors = new ArrayList<>();

        if(Objects.isNull(ligneVenteDto)){
            errors.add("Veillez renseigner la vente !");
            errors.add("Veillez renseigner la quantité !");
            return errors;
        }
        if(Objects.isNull(ligneVenteDto.getVenteDto())){
            errors.add("Veillez renseigner la vente !");
            return errors;
        }
        if(Objects.isNull(ligneVenteDto.getQuantite())){
            errors.add("Veillez renseigner la quantité !");
            return errors;
        }

        return errors;
    }
}
