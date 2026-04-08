package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioSummaryDTO;

public record FuncionarioDetailDTO(
        String matricula,
        UsuarioSummaryDTO usuario
) {
}
