package br.com.indra.renato_santana.controller;

import br.com.indra.renato_santana.model.HistoricoTransacao;
import br.com.indra.renato_santana.service.HistoricoTransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/historico")

public class HistoricoTransacaoController {

    private final HistoricoTransacaoService historicoTransacaoService;

    @PostMapping("/criarHistorico")
    public ResponseEntity<HistoricoTransacao> criarHistorico(@RequestBody HistoricoTransacao historico) {
        return ResponseEntity.ok(historicoTransacaoService.createHistorico(historico));
    }

    @GetMapping
    public ResponseEntity<List<HistoricoTransacao>> getAll() {
        return ResponseEntity.ok(historicoTransacaoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoTransacao> getById(@PathVariable Long id) {
        return ResponseEntity.ok(historicoTransacaoService.getById(id));
    }

    @PutMapping("/atualizarHistorico")
    public ResponseEntity<HistoricoTransacao> atualizarHistorico(@RequestParam Long id, @RequestBody HistoricoTransacao historico) {
        return ResponseEntity.ok(historicoTransacaoService.atualizarHistorico(id, historico));
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<Void> deletarHistorico(@PathVariable Long id) {
        historicoTransacaoService.deletarHistorico(id);
        return ResponseEntity.noContent().build();
    }
}
