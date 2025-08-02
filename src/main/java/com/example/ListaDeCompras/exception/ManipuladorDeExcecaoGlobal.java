package com.example.ListaDeCompras.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ManipuladorDeExcecaoGlobal {

    private static final Logger logger = LoggerFactory.getLogger(ManipuladorDeExcecaoGlobal.class);

    @ExceptionHandler(RecursoNaoEncontradoExcecao.class)
    public ResponseEntity<String> manipuladorNaoEncontrado(RecursoNaoEncontradoExcecao ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        logger.error("Ocorreu um erro interno não esperado.", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno no servidor. Por favor, tente novamente mais tarde.");
    }
}