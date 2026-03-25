package br.com.indra.renato_santana.controller;

import br.com.indra.renato_santana.model.Usuario;
import br.com.indra.renato_santana.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/criaUsuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @PutMapping("/atualizarUsuario")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestParam Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuario));
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
