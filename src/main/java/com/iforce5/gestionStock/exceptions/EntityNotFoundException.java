package com.iforce5.gestionStock.exceptions;

import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import lombok.Getter;

public class EntityNotFoundException extends  RuntimeException{

    @Getter
    private ErrosCodes errorCode;

    public EntityNotFoundException(String message,ErrosCodes errorCode,Throwable cause) {
        super(message,cause);
        this.errorCode = errorCode;
    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EntityNotFoundException(String message,ErrosCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
