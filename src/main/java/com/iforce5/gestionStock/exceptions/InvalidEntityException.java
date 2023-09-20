package com.iforce5.gestionStock.exceptions;

import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException {

    @Getter
    private ErrosCodes errosCode;
    @Getter
    private List<String> errorsList;


    public InvalidEntityException(String message) {
        super(message);

    }
    public InvalidEntityException(String message, ErrosCodes errosCode) {
        super(message);
        this.errosCode = errosCode;
    }


    public InvalidEntityException(String message, Throwable cause, ErrosCodes errosCode) {
        super(message, cause);
        this.errosCode = errosCode;
    }

    public InvalidEntityException(String message,ErrosCodes errosCode, List<String> errorsList) {
        super(message);
        this.errosCode = errosCode;
        this.errorsList = errorsList;
    }
}
