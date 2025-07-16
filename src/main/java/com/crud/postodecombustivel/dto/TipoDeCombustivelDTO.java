package com.crud.postodecombustivel.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) para a entidade TipoDeCombustivel.
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
public class TipoDeCombustivelDTO {
    private Long id;
    private String nomeCombustivel;
    private BigDecimal precoPorLitro;
}
