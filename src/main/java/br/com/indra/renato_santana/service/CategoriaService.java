package br.com.indra.renato_santana.service;

import br.com.indra.renato_santana.model.Categoria;
import br.com.indra.renato_santana.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;


    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria getById(Long id) {
        return categoriaRepository.findById(id).get();
    }
}
