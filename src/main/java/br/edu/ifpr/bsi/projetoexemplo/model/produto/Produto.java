package br.edu.ifpr.bsi.projetoexemplo.model.produto;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import jakarta.persistence.*;

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

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;
}
