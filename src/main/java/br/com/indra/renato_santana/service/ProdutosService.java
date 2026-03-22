package br.com.indra.renato_santana.service;

import br.com.indra.renato_santana.model.Produtos;
import br.com.indra.renato_santana.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final ProdutosRepository produtosRepository;


    public List<Produtos> getAll() {
        return produtosRepository.findAll();
    }

    public Produtos createProduto(Produtos produto) {
        return produtosRepository.save(produto);
    }

    public Produtos atualizar(Produtos produto) {
        return produtosRepository.save(produto);
    }

    public List<Produtos> buscarPorNome(String nome) {
        return produtosRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produtos> buscarPorCategoria(Long id) {
        return produtosRepository.findByCategoriaId(id);
    }

    public void deletarProduto(Long id) {
       final var produto = produtosRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
       produto.setIsActive(false);
       produtosRepository.saveAndFlush(produto);
    }

    public Produtos getById(Long id) {
        return produtosRepository.findById(id).get();
    }

    public Produtos atualizaPreco(Long id, BigDecimal preco) {
        final var produto = produtosRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setPreco(preco);

        return produtosRepository.saveAndFlush(produto);

    }
}