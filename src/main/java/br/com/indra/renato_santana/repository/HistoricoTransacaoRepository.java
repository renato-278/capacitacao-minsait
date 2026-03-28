package br.com.indra.renato_santana.repository;

import br.com.indra.renato_santana.model.HistoricoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoTransacaoRepository extends JpaRepository<HistoricoTransacao, Long> {
}
