package br.edu.ifpr.bsi.projetoexemplo.model;

import br.edu.ifpr.bsi.projetoexemplo.enums.Role;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class Usuario extends GenericModel {
    private String username;

    private String password;

    @Transient // Não será persistida no banco de dados, usada apenas para receber a senha pura na autenticação
    private String senhaLocal;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario")
    private Funcionario funcionario;

}
