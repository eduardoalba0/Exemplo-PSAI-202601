package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_funcionario")
public class Funcionario extends GenericModel {

    private String matricula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

}
