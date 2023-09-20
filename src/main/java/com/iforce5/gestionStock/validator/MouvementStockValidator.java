package com.iforce5.gestionStock.validator;

import com.iforce5.gestionStock.dto.MouvementStockDto;
import com.iforce5.gestionStock.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MouvementStockValidator {


    public static List<String> validator(MouvementStockDto mouvementStockDto){

        List<String> errors = new ArrayList<>();

        if(Objects.isNull(mouvementStockDto)){
            errors.add("Veillez renseigner le code !");
            errors.add("Veillez renseigner l'article !");
            errors.add("Veillez renseigner le type de mouvement de stock !");
            return errors;
        }
        if(StringUtils.hasLength(mouvementStockDto.getCode())){
            errors.add("Veillez renseigner code de la vente !");
            return errors;
        }
        if(Objects.isNull(mouvementStockDto.getQuantite())){
            errors.add("Veillez renseigner la quantité !");
            return errors;
        }
        if(Objects.isNull(mouvementStockDto.getTypeMvtDto())){
            errors.add("Veillez renseigner le type !");
            return errors;
        }

        return errors;
    }
}
