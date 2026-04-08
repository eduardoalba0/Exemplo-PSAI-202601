package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

import br.edu.ifpr.bsi.projetoexemplo.enums.Role;
import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
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

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario")
    private Funcionario funcionario;

}
