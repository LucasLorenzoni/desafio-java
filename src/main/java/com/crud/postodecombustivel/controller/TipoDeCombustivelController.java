package com.crud.postodecombustivel.controller;

import com.crud.postodecombustivel.business.TipoDeCombustivelService;
import com.crud.postodecombustivel.dto.TipoDeCombustivelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-combustivel")
@RequiredArgsConstructor
public class TipoDeCombustivelController {

    // Injeção do serviço que contém a lógica de negócio para tipos de combustível.
    private final TipoDeCombustivelService service;

    // Registra um novo tipo de combustível.
    @PostMapping
    public ResponseEntity<TipoDeCombustivelDTO> criar(@RequestBody TipoDeCombustivelDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    // Lista todos os tipos de combustível cadastrados.
    @GetMapping
    public ResponseEntity<List<TipoDeCombustivelDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // Busca um tipo de combustível pelo seu ID.
    @GetMapping("/{id}")
    public ResponseEntity<TipoDeCombustivelDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Atualiza um tipo de combustível existente.
    @PutMapping("/{id}")
    public ResponseEntity<TipoDeCombustivelDTO> atualizar(@PathVariable Long id,
                                                          @RequestBody TipoDeCombustivelDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // Remove um tipo de combustível pelo ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
