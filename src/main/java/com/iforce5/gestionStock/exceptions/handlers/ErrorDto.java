package com.iforce5.gestionStock.exceptions.handlers;

import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ErrorDto {

    private Integer httpCode;
    private ErrosCodes errorCode;
    private String message;
    private List<String> errors = new ArrayList<>();
}
