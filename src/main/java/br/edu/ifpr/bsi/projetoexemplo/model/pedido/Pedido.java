package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_pedido")
public class Pedido extends GenericModel {

    // Anotação para indicar que o campo deve ser preenchido automaticamente com a data de criação do registro
    @CreatedDate
    @Column(name = "data_pedido")
    private LocalDateTime data;

    @Column(name = "descricao_pedido")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "tb_produtos_pedido",// Nome da tabela de junção
            joinColumns = @JoinColumn(name = "pedido_id"), // FK desta entidade (Pedido)
            inverseJoinColumns = @JoinColumn(name = "produto_id") // FK da entidade relacionada (Produto)
    )
    private List<Produto> produtos;

}
