package br.com.indra.renato_santana.service;

import br.com.indra.renato_santana.model.Produto;
import br.com.indra.renato_santana.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtosRepository;


    public List<Produto> getAll() {
        return produtosRepository.findAll();
    }

    public Produto createProduto(Produto produto) {
        return produtosRepository.save(produto);
    }

    public Produto atualizar(Produto produto) {
        return produtosRepository.save(produto);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtosRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produto> buscarPorCategoria(Long id) {
        return produtosRepository.findByCategoriaId(id);
    }

    public void deletarProduto(Long id) {
       final var produto = produtosRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
       produto.setIsActive(false);
       produtosRepository.saveAndFlush(produto);
    }

    public Produto getById(Long id) {
        return produtosRepository.findById(id).get();
    }

    public Produto atualizaPreco(Long id, BigDecimal preco) {
        final var produto = produtosRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setPreco(preco);

        return produtosRepository.saveAndFlush(produto);

    }
}