package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_funcionario")
@DiscriminatorValue("FUNCIONARIO")
public class Funcionario extends Usuario {

    private String matricula;

}
