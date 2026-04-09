package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioSummaryDTO;

public record FuncionarioDetailDTO(
        Long codigo,
        String matricula,
        UsuarioSummaryDTO usuario
) {
}
