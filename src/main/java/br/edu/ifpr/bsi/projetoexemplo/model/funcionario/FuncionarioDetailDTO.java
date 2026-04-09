package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioDetailDTO;

public record FuncionarioDetailDTO (
        Long codigo,
        String username,
        String matricula,
        String role
) implements UsuarioDetailDTO {
}
