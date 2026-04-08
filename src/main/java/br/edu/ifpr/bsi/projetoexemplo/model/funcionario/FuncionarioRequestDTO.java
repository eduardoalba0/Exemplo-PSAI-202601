package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioRequestDTO;

public record FuncionarioRequestDTO(
        String matricula,
        UsuarioRequestDTO usuario
) {
}
