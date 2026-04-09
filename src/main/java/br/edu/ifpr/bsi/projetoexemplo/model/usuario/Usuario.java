package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

import br.edu.ifpr.bsi.projetoexemplo.enums.Role;
import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario extends GenericModel {

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", insertable = false, updatable = false)
    private Role role;
}
