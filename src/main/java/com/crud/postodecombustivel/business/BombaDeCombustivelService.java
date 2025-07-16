package com.crud.postodecombustivel.business;

import com.crud.postodecombustivel.dto.BombaDeCombustivelDTO;
import com.crud.postodecombustivel.infrastructure.entity.BombaDeCombustivel;
import com.crud.postodecombustivel.infrastructure.entity.TipoDeCombustivel;
import com.crud.postodecombustivel.infrastructure.exceptions.ConflictException;
import com.crud.postodecombustivel.infrastructure.repository.BombaDeCombustivelRepository;
import com.crud.postodecombustivel.infrastructure.repository.TipoDeCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de serviço responsável pela lógica de negócio associada ao recurso TipoDeCombustivel.
 * Atua como intermediária entre os controladores e os repositórios.
 */

@Service
@RequiredArgsConstructor
public class BombaDeCombustivelService {
    // Repositório de acesso à base de dados para TipoDeCombustivel.
    private final BombaDeCombustivelRepository repository;

    // Repositório utilizado para verificar a existência do tipo de combustível associado à bomba.
    private final TipoDeCombustivelRepository tipoRepository;

    // Cria e salva uma nova bomba de combustível no banco de dados.
    public BombaDeCombustivelDTO salvar(BombaDeCombustivelDTO dto) {
        TipoDeCombustivel tipo = tipoRepository.findById(dto.getTipoCombustivelId())
                .orElseThrow(() -> new ConflictException("Tipo não encontrado"));
        BombaDeCombustivel bomba = new BombaDeCombustivel();
        bomba.setNomeBomba(dto.getNomeBomba());
        bomba.setTipoCombustivel(tipo);
        return toDTO(repository.save(bomba));
    }

    // Retorna todas as bombas de combustível cadastradas.
    public List<BombaDeCombustivelDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Busca uma bomba específica pelo ID.
    public BombaDeCombustivelDTO buscarPorId(Long id) {
        return toDTO(repository.findById(id)
                .orElseThrow(() -> new ConflictException("Bomba não encontrada: " + id)));
    }

    // Atualiza os dados de uma bomba existente.
    public BombaDeCombustivelDTO atualizar(Long id, BombaDeCombustivelDTO dto) {
        BombaDeCombustivel existente = repository.findById(id)
                .orElseThrow(() -> new ConflictException("Bomba não encontrada"));
        TipoDeCombustivel tipo = tipoRepository.findById(dto.getTipoCombustivelId())
                .orElseThrow(() -> new ConflictException("Tipo não encontrado"));
        existente.setNomeBomba(dto.getNomeBomba());
        existente.setTipoCombustivel(tipo);
        return toDTO(repository.save(existente));
    }

    // Exclui uma bomba do sistema com base em seu ID.
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // Converte uma entidade BombaDeCombustivel em um DTO para exposição segura de dados.
    private BombaDeCombustivelDTO toDTO(BombaDeCombustivel bomba) {
        BombaDeCombustivelDTO dto = new BombaDeCombustivelDTO();
        dto.setId(bomba.getId());
        dto.setNomeBomba(bomba.getNomeBomba());
        dto.setTipoCombustivelId(bomba.getTipoCombustivel().getId());
        return dto;
    }
}