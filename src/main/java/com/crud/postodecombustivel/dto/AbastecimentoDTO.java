package com.crud.postodecombustivel.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) para a entidade Abastecimento.
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
public class AbastecimentoDTO {
    private Long id;
    private LocalDate dataAbastecimento;
    private BigDecimal litrosAbastecimento;
    private BigDecimal valorTotal;
    private Long bombaId;
}
