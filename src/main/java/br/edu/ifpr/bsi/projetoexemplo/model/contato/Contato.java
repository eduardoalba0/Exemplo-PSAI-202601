package br.edu.ifpr.bsi.projetoexemplo.model.contato;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_contato")
public class Contato extends GenericModel {

    @Column(name="telefone_contato")
    private String telefone;

    @Column(name="email_contato")
    private String email;

    @Column(name="whatsapp_contato")
    private String whatsapp;

    // Embora o cliente também tenha uma lista de contatos, a relação é @ManyToOne aqui porque cada contato pertence a um único cliente
    // O correto é ter um relacionamento bidirecional, se não, o JPA cria uma tabela intermediária para gerenciar a relação @OneToMany, o que não é necessário neste caso aqui
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
}
