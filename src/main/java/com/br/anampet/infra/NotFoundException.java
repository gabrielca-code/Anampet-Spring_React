package com.br.anampet.infra;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Object id) {
        super("Recurso não encontrado " + id);
    }

}