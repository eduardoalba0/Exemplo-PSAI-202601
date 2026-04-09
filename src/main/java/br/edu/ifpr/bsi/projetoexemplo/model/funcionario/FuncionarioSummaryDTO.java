package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioSummaryDTO;

public record FuncionarioSummaryDTO(
        Long codigo,
        String matricula,
        String username,
        String role
) implements UsuarioSummaryDTO {
}
