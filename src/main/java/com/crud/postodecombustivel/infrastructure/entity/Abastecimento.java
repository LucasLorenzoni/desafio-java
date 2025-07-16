package com.crud.postodecombustivel.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "abastecimento")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do abastecimento

    @Column(name = "data_abastecimento", nullable = false)
    private LocalDate dataAbastecimento; // Data do abastecimento

    @Column(name = "litros_abastecimento", precision = 10, scale = 2, nullable = false)
    private BigDecimal litrosAbastecimento; // Quantidade de litros abastecidos

    @Column(name = "valor_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorTotal; // Valor total do abastecimento

    @ManyToOne
    @JoinColumn(name = "bomba_id", nullable = false)
    @JsonIgnoreProperties("abastecimentos")
    private BombaDeCombustivel bomba; // Relação com a bomba onde o abastecimento foi realizado
}
