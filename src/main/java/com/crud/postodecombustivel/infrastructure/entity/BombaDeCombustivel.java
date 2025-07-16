package com.crud.postodecombustivel.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bomba_combustivel")
public class BombaDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da bomba de combustível

    @Column(name = "nome_bomba", length = 50, nullable = false)
    private String nomeBomba; // Nome ou número da bomba (ex: Bomba 01)

    @ManyToOne
    @JoinColumn(name = "tipo_combustivel_id", nullable = false)
    @JsonIgnoreProperties("bombasPosto")
    private TipoDeCombustivel tipoCombustivel; // Relação com o tipo de combustível utilizado nesta bomba

    @OneToMany(mappedBy = "bomba", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Abastecimento> abastecimentos = new ArrayList<>(); // Lista de abastecimentos realizados nesta bomba
}
