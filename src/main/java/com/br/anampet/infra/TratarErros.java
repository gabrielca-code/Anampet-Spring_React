package com.br.anampet.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity errosDados(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }

}
