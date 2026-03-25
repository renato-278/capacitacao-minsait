package br.com.indra.renato_santana.controller;

import br.com.indra.renato_santana.model.Categoria;
import br.com.indra.renato_santana.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")

public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping("/criaCategoria")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.createCategoria(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.getById(id));
    }

    @PutMapping("/atualizaCategoria")
    public ResponseEntity<Categoria> atualizarCategoria(@RequestParam Long id, @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.atualizarCategoria(categoria));
    }

    @DeleteMapping("/deletaCategoria/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }


}
