package br.edu.ifpr.bsi.projetoexemplo.model.endereco;

import br.edu.ifpr.bsi.projetoexemplo.model.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
public class Endereco extends GenericModel {

    @Column(name = "cep_endereco")
    private String cep;

    @Column(name = "logradouro_endereco")
    private String logradouro;

    @Column(name = "bairro_endereco")
    private String bairro;

    @Column(name = "numero_endereco")
    private String numero;

    @Column(name = "cidade_endereco")
    private String cidade;

}
