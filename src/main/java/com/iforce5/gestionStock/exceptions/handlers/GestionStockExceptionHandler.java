package com.iforce5.gestionStock.exceptions.handlers;

import com.iforce5.gestionStock.exceptions.EntityNotFoundException;
import com.iforce5.gestionStock.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GestionStockExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerException(EntityNotFoundException entityNotFoundException, WebRequest
            webRequest){

        final HttpStatus notFound =   HttpStatus.NOT_FOUND;
        final  ErrorDto errorDto = ErrorDto.builder()
                .errorCode(entityNotFoundException.getErrorCode())
                .httpCode(notFound.value())
                .message(entityNotFoundException.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handlerException(InvalidEntityException invalidEntityException, WebRequest
            webRequest){
        final HttpStatus badRequest =   HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto =  ErrorDto.builder()
                .errorCode(invalidEntityException.getErrosCode())
                .httpCode(badRequest.value())
                .message(invalidEntityException.getMessage())
                .errors(invalidEntityException.getErrorsList())
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }

}
