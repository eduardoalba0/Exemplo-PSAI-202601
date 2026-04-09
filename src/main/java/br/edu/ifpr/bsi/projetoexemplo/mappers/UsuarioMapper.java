package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.funcionario.Funcionario;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.Usuario;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioDetailDTO;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public UsuarioDetailDTO entityToDetailDTO(Usuario usuario) {
        switch (usuario.getRole()) {
            case CLIENTE -> {
                return clienteMapper.entityToDetailDTO((Cliente) usuario);
            }
            case FUNCIONARIO -> {
                return funcionarioMapper.entityToDetailDTO((Funcionario) usuario);
            }
        }
        throw new IllegalStateException("Tipo de usuário desconhecido: " + usuario.getClass());
    }
}
