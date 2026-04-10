package br.edu.ifpr.bsi.projetoexemplo.model.produto;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_produtos")
public class Produto extends GenericModel {

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "preco_produto")
    private Double preco;

    // O relacionamento @ManyToMany é bidirecional, então mapeamos o lado inverso do relacionamento aqui usando mappedBy, indicando que a entidade Pedido é a dona do relacionamento
    @ManyToMany(mappedBy = "produtosPedido")
    private List<Pedido> pedidosProduto;
}










