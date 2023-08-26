package com.groovil.restapi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EtBadRequestExecption extends RuntimeException{
    public EtBadRequestExecption(String message) {
        super(message);
    }
}
