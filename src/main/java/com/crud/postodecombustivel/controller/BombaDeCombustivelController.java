package com.crud.postodecombustivel.controller;

import com.crud.postodecombustivel.business.BombaDeCombustivelService;
import com.crud.postodecombustivel.dto.BombaDeCombustivelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bombas")
@RequiredArgsConstructor
public class BombaDeCombustivelController {
    // Injeção do serviço que contém as regras de negócio para bombas.
    private final BombaDeCombustivelService service;

    // Registra uma nova bomba de combustível.
    @PostMapping
    public ResponseEntity<BombaDeCombustivelDTO> criar(@RequestBody BombaDeCombustivelDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    // Lista todas as bombas cadastradas.
    @GetMapping
    public ResponseEntity<List<BombaDeCombustivelDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // Busca uma bomba de combustível pelo seu ID.
    @GetMapping("/{id}")
    public ResponseEntity<BombaDeCombustivelDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Atualiza uma bomba de combustível existente.
    @PutMapping("/{id}")
    public ResponseEntity<BombaDeCombustivelDTO> atualizar(@PathVariable Long id,
                                                           @RequestBody BombaDeCombustivelDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // Remove uma bomba de combustível pelo ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
