package br.com.indra.renato_santana.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_carrinho")
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    private Integer quantidade;

    @Column(name = "preco_snapshot", nullable = false)
    private BigDecimal precoSnapshot;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
