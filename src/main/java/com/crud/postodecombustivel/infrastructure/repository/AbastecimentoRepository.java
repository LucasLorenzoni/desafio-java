package com.crud.postodecombustivel.infrastructure.repository;

import com.crud.postodecombustivel.infrastructure.entity.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável por fornecer operações de acesso a dados
 * para a entidade Abastecimento.
 *
 * Estende JpaRepository, o que permite herdar diversos métodos prontos
 * como salvar, atualizar, deletar e consultar registros no banco de dados.
 *
 * O parâmetro <Abastecimento, Long> indica que esta interface trabalha
 * com a entidade Abastecimento, cuja chave primária é do tipo Long.
 */

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
}
