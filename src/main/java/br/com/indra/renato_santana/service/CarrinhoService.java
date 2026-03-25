package br.com.indra.renato_santana.service;

import br.com.indra.renato_santana.model.Carrinho;
import br.com.indra.renato_santana.model.ItemCarrinho;
import br.com.indra.renato_santana.model.Produto;
import br.com.indra.renato_santana.repository.CarrinhoRepository;
import br.com.indra.renato_santana.repository.ItemCarrinhoRepository;
import br.com.indra.renato_santana.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    public List<Carrinho> getAll() {
        return carrinhoRepository.findAll();
    }

    public Carrinho createCarrinho(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho adicionarItem(Long carrinhoId, Long produtoId) {

        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ItemCarrinho item = new ItemCarrinho();
        item.setCarrinho(carrinho);
        item.setProduto(produto);
        item.setQuantidade(1);
        item.setPrecoSnapshot(produto.getPreco());

        itemCarrinhoRepository.save(item);

        return carrinho;
    }

    public void removerItem(Long carrinhoId, Long produtoId) {

        ItemCarrinho item = itemCarrinhoRepository.findByCarrinhoIdAndProdutoId(carrinhoId, produtoId).orElseThrow(() -> new RuntimeException("Item não encontrado no carrinho"));

        itemCarrinhoRepository.delete(item);
    }

}
