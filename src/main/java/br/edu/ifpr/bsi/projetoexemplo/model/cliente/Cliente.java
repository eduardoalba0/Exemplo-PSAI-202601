package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.Endereco;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
public class Cliente extends GenericModel {

    @Column(name = "nome_cliente")
    private String nome;

    @Column(name = "cpf_cliente", unique = true)
    private String cpf;

    @Column(name = "email_cliente")
    private String email;

    @Column(name = "senha_cliente")
    private String senha;

    @Column(name= "url_imagem")
    private String urlImagem;

    // Um cliente tem só um endereço
    // CascadeType.ALL faz com que as operações em Cliente sejam propagadas para Endereco
    // FetchType.EAGER indica que o endereço deve ser carregado imediatamente junto com o cliente
    // CUIDADO com o EAGER em relacionamentos @OneToMany, pois pode causar problemas de desempenho se houver muitos contatos para um cliente
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    // Um cliente pode ter vários contatos
    // MappedBy indica que o relacionamento é bidirecional e que a entidade Contato é a dona do relacionamento (ou seja, a tabela de contatos terá uma coluna cliente_id)
    // CascadeType.ALL faz com que as operações em Cliente sejam propagadas para Contato
    // FetchType.LAZY indica que os contatos devem ser carregados somente quando forem acessados, o que pode melhorar o desempenho se o endereço não for sempre necessário
    // OrphanRemoval = true garante que, se um contato for removido da lista de contatos do cliente, ele também será removido do banco de dados
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();

    // Um cliente pode ter vários pedidos
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public void adicionarContato(Contato contato) {
        contato.setCliente(this);
        this.contatos.add(contato);
    }

    public void removerContato(Contato contato) {
        contato.setCliente(null);
        this.contatos.remove(contato);
    }
}
