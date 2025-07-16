package com.crud.postodecombustivel.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) para a entidade BombaDeCombustivel.
 *
 * Essa classe tem como objetivo transportar dados entre o cliente (API)
 * e o servidor, isolando a camada de persistência (entidade JPA).
 *
 * É útil para evitar o vazamento de entidades completas com relacionamentos complexos
 * e, também, para personalizar o que será exposto via API.
 *
 * Anotação @Data (Lombok):
 * Gera automaticamente os métodos getters, setters, toString,
 * equals, e hashCode, além de um construtor padrão.
 */

@Data
public class BombaDeCombustivelDTO {
    private Long id;
    private String nomeBomba;
    private Long tipoCombustivelId;
}
