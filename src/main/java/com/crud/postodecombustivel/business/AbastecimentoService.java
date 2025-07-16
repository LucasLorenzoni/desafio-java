package com.crud.postodecombustivel.business;

import com.crud.postodecombustivel.dto.AbastecimentoDTO;
import com.crud.postodecombustivel.infrastructure.entity.Abastecimento;
import com.crud.postodecombustivel.infrastructure.entity.BombaDeCombustivel;
import com.crud.postodecombustivel.infrastructure.exceptions.ConflictException;
import com.crud.postodecombustivel.infrastructure.repository.AbastecimentoRepository;
import com.crud.postodecombustivel.infrastructure.repository.BombaDeCombustivelRepository;
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
public class AbastecimentoService {
    // Repositório para operações com a entidade Abastecimento
    private final AbastecimentoRepository repository;

    // Repositório para verificar e buscar a bomba associada ao abastecimento.
    private final BombaDeCombustivelRepository bombaRepository;

    // Cria e salva um novo abastecimento.
    public AbastecimentoDTO salvar(AbastecimentoDTO dto) {
        BombaDeCombustivel bomba = bombaRepository.findById(dto.getBombaId())
                .orElseThrow(() -> new ConflictException("Bomba não encontrada"));
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setDataAbastecimento(dto.getDataAbastecimento());
        abastecimento.setLitrosAbastecimento(dto.getLitrosAbastecimento());
        abastecimento.setValorTotal(dto.getValorTotal());
        abastecimento.setBomba(bomba);
        return toDTO(repository.save(abastecimento));
    }

    // Lista todos os abastecimentos cadastrados.
    public List<AbastecimentoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Busca um abastecimento pelo seu ID.
    public AbastecimentoDTO buscarPorId(Long id) {
        return toDTO(repository.findById(id)
                .orElseThrow(() -> new ConflictException("Abastecimento não encontrado")));
    }

    // Atualiza os dados de um abastecimento existente.
    public AbastecimentoDTO atualizar(Long id, AbastecimentoDTO dto) {
        Abastecimento existente = repository.findById(id)
                .orElseThrow(() -> new ConflictException("Abastecimento não encontrado"));
        BombaDeCombustivel bomba = bombaRepository.findById(dto.getBombaId())
                .orElseThrow(() -> new ConflictException("Bomba não encontrada"));
        existente.setDataAbastecimento(dto.getDataAbastecimento());
        existente.setLitrosAbastecimento(dto.getLitrosAbastecimento());
        existente.setValorTotal(dto.getValorTotal());
        existente.setBomba(bomba);
        return toDTO(repository.save(existente));
    }

    // Exclui um abastecimento pelo ID.
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // Converte uma entidade Abastecimento para um DTO.
    private AbastecimentoDTO toDTO(Abastecimento abastecimento) {
        AbastecimentoDTO dto = new AbastecimentoDTO();
        dto.setId(abastecimento.getId());
        dto.setDataAbastecimento(abastecimento.getDataAbastecimento());
        dto.setLitrosAbastecimento(abastecimento.getLitrosAbastecimento());
        dto.setValorTotal(abastecimento.getValorTotal());
        dto.setBombaId(abastecimento.getBomba().getId());
        return dto;
    }
}
