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
    private final ProdutoService produtosService;

    @PostMapping("/cria")
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtosService.createProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtosService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(produtosService.getById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtosService.buscarPorNome(nome));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(produtosService.buscarPorCategoria(id));
    }

    @PutMapping("/atualiza")
    public ResponseEntity<Produto> atualizarProduto(@RequestParam Long id, @RequestBody Produto produto) {
        return ResponseEntity.ok(produtosService.atualizar(produto));
    }

    @PatchMapping("/atualiza-preco/{id}")
    public ResponseEntity<Produto> atualizarProdutoParcial(@PathVariable Long id, @RequestParam BigDecimal preco) {
        return ResponseEntity.ok(produtosService.atualizaPreco(id, preco));
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtosService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
