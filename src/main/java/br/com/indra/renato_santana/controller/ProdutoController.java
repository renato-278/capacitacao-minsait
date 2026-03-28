package br.com.indra.renato_santana.controller;

import br.com.indra.renato_santana.model.Produto;
import br.com.indra.renato_santana.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")

public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping("/cria")
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.createProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.getById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorCategoria(id));
    }

    @PutMapping("/atualiza")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.atualizar(produto));
    }

    @PatchMapping("/atualiza-preco/{id}")
    public ResponseEntity<Produto> atualizarProdutoParcial(@PathVariable Long id, @RequestParam BigDecimal preco) {
        return ResponseEntity.ok(produtoService.atualizaPreco(id, preco));
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
