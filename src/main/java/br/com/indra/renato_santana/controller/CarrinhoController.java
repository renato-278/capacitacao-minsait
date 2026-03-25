package br.com.indra.renato_santana.controller;

import br.com.indra.renato_santana.model.Carrinho;
import br.com.indra.renato_santana.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carrinho")
public class CarrinhoController {
    private final CarrinhoService carrinhoService;

    @PostMapping("/criaCarrinho")
    public ResponseEntity<Carrinho> criarCarrinho(@RequestBody Carrinho carrinho) {
        return ResponseEntity.ok(carrinhoService.createCarrinho(carrinho));
    }

    @GetMapping
    public ResponseEntity<List<Carrinho>> getAll() {
        return ResponseEntity.ok(carrinhoService.getAll());
    }

    @PostMapping("/adicionarItem/{carrinhoId}/produto/{produtoId}")
    public ResponseEntity<Carrinho> adicionarItem(@PathVariable Long carrinhoId, @PathVariable Long produtoId) {
        return ResponseEntity.ok(carrinhoService.adicionarItem(carrinhoId, produtoId));
    }

    @DeleteMapping("/{carrinhoId}/produto/{produtoId}")
    public ResponseEntity<Void> removerItem(@PathVariable Long carrinhoId, @PathVariable Long produtoId) {
        carrinhoService.removerItem(carrinhoId, produtoId);
        return ResponseEntity.noContent().build();
    }
}
