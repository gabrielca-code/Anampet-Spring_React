package com.br.anampet.infra;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundException extends RuntimeException {

    public NotFoundException(Object id) {
        super("Recurso não encontrado " + id);
    }

}