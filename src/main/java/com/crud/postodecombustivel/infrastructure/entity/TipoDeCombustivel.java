package com.crud.postodecombustivel.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_combustivel")
public class TipoDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do tipo de combustível

    @Column(name = "nome_combustivel", length = 50, nullable = false)
    private String nomeCombustivel; // Nome do combustível (ex: Gasolina, Etanol)

    @Column(name = "preco_por_litro", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoPorLitro; // Preço por litro do combustível

    @OneToMany(mappedBy = "tipoCombustivel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BombaDeCombustivel> bombasPosto = new ArrayList<>(); // Lista de bombas associadas a este tipo de combustível
}
