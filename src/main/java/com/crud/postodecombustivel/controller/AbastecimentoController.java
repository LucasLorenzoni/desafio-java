package com.crud.postodecombustivel.controller;

import com.crud.postodecombustivel.business.AbastecimentoService;
import com.crud.postodecombustivel.dto.AbastecimentoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abastecimentos")
@RequiredArgsConstructor
public class AbastecimentoController {
    // Injeção do serviço que contém as regras de negócio para abastecimentos.
    private final AbastecimentoService service;

    // Registra um novo abastecimento no sistema.
    @PostMapping
    public ResponseEntity<AbastecimentoDTO> criar(@RequestBody AbastecimentoDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    // Lista todos os abastecimentos cadastrados.
    @GetMapping
    public ResponseEntity<List<AbastecimentoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // Busca um abastecimento específico pelo seu ID.
    @GetMapping("/{id}")
    public ResponseEntity<AbastecimentoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Atualiza um abastecimento existete.
    @PutMapping("/{id}")
    public ResponseEntity<AbastecimentoDTO> atualizar(@PathVariable Long id,
                                                      @RequestBody AbastecimentoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // Remove um abastecimento pelo ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
