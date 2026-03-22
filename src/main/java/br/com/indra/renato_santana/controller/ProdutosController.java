package br.com.indra.renato_santana.controller;

import br.com.indra.renato_santana.model.Produtos;
import br.com.indra.renato_santana.service.ProdutosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")

public class ProdutosController {
    private final ProdutosService produtosService;

    @PostMapping("/cria")
    public ResponseEntity<Produtos> criarProduto(@Valid @RequestBody Produtos produto) {
        return ResponseEntity.ok(produtosService.createProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> getAll() {
        return ResponseEntity.ok(produtosService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getById(@PathVariable Long id) {
        return ResponseEntity.ok(produtosService.getById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produtos>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtosService.buscarPorNome(nome));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Produtos>> buscarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(produtosService.buscarPorCategoria(id));
    }

    @PutMapping("/atualiza")
    public ResponseEntity<Produtos> atualizarProduto(@RequestParam Long id, @RequestBody Produtos produto) {
        return ResponseEntity.ok(produtosService.atualizar(produto));
    }

    @PatchMapping("/atualiza-preco/{id}")
    public ResponseEntity<Produtos> atualizarProdutoParcial(@PathVariable Long id, @RequestParam BigDecimal preco) {
        return ResponseEntity.ok(produtosService.atualizaPreco(id, preco));
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtosService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
