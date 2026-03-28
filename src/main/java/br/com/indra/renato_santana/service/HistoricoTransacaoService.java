package br.com.indra.renato_santana.service;

import br.com.indra.renato_santana.model.HistoricoTransacao;
import br.com.indra.renato_santana.repository.HistoricoTransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricoTransacaoService {
    private final HistoricoTransacaoRepository historicoRepository;

    public HistoricoTransacao createHistorico(HistoricoTransacao historico) {

        historico.setDataTransacao(LocalDateTime.now());

        return historicoRepository.save(historico);
    }

    public List<HistoricoTransacao> getAll() {
        return historicoRepository.findAll();
    }

    public HistoricoTransacao getById(Long id) {
        return historicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Histórico não encontrado"));
    }

    public HistoricoTransacao atualizarHistorico(Long id, HistoricoTransacao historicoAtualizado) {

        HistoricoTransacao historico = historicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Histórico não encontrado"));

        historico.setStatus(historicoAtualizado.getStatus());
        historico.setTipoTransacao(historicoAtualizado.getTipoTransacao());
        historico.setValorTotal(historicoAtualizado.getValorTotal());
        historico.setUpdatedAt(LocalDateTime.now());

        return historicoRepository.save(historico);
    }

    public void deletarHistorico(Long id) {
        historicoRepository.deleteById(id);
    }
}
