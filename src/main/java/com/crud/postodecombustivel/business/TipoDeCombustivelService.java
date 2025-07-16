package com.crud.postodecombustivel.business;

import com.crud.postodecombustivel.dto.TipoDeCombustivelDTO;
import com.crud.postodecombustivel.infrastructure.entity.TipoDeCombustivel;
import com.crud.postodecombustivel.infrastructure.exceptions.ConflictException;
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
public class TipoDeCombustivelService {
    // Repositório de acesso à base de dados para TipoDeCombustivel.
    private final TipoDeCombustivelRepository repository;

    // Cria e salva um novo Tipo de Combustível com base nos dados recebidos no DTO.
    public TipoDeCombustivelDTO salvar(TipoDeCombustivelDTO dto) {
        TipoDeCombustivel entity = new TipoDeCombustivel();
        entity.setNomeCombustivel(dto.getNomeCombustivel());
        entity.setPrecoPorLitro(dto.getPrecoPorLitro());
        return toDTO(repository.save(entity));
    }

    // Retorna todos os tipos de combustível cadastrados no sistema.
    public List<TipoDeCombustivelDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Busca um Tipo de Combustível específico pelo ID.
    public TipoDeCombustivelDTO buscarPorId(Long id) {
        return toDTO(repository.findById(id)
                .orElseThrow(() -> new ConflictException("Tipo não encontrado: " + id)));
    }

    // Atualiza um tipo de combustível existente com base no ID fornecido.
    public TipoDeCombustivelDTO atualizar(Long id, TipoDeCombustivelDTO dto) {
        TipoDeCombustivel existente = repository.findById(id)
                .orElseThrow(() -> new ConflictException("Tipo não encontrado: " + id));
        existente.setNomeCombustivel(dto.getNomeCombustivel());
        existente.setPrecoPorLitro(dto.getPrecoPorLitro());
        return toDTO(repository.save(existente));
    }

    // Exclui um tipo de combustível com base no seu ID.
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ConflictException("Tipo não encontrado: " + id);
        }
        repository.deleteById(id);
    }

    // Converte uma entidade TipoDeCombustivel em um DTO para exposição segura de dados.
    private TipoDeCombustivelDTO toDTO(TipoDeCombustivel tipo) {
        TipoDeCombustivelDTO dto = new TipoDeCombustivelDTO();
        dto.setId(tipo.getId());
        dto.setNomeCombustivel(tipo.getNomeCombustivel());
        dto.setPrecoPorLitro(tipo.getPrecoPorLitro());
        return dto;
    }
}
