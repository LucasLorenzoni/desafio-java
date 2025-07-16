package com.crud.postodecombustivel.infrastructure.exceptions;

/**
 * Exceção personalizada para representar conflitos de negócio (HTTP 409 Conflict),
 * como tentativas de cadastrar registros duplicados ou violações de regras.
 */

public class ConflictException extends RuntimeException{

    // Construtor que aceita apenas uma mensagem explicativa sobre o conflito ocorrido.
    public ConflictException(String mensagem){

        super(mensagem);
    }
    // Construtor que aceita uma mensagem e uma causa original (Throwable),
    // permitindo encadear exceções para rastrear a origem do erro.
    public ConflictException(String mensagem, Throwable throwable){

        super(mensagem, throwable);
    }
}
