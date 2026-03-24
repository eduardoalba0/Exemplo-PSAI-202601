package br.edu.ifpr.bsi.projetoexemplo.model.produto;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produtos")
public class Produto extends GenericModel {

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "preco_produto")
    private Double preco;
}
