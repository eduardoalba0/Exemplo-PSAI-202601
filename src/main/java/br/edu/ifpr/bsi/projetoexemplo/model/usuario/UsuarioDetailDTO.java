package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.funcionario.FuncionarioSummaryDTO;

public record UsuarioDetailDTO(
        Long codigo,
        String username,
        String role,
        FuncionarioSummaryDTO funcionario,
        ClienteSummaryDTO cliente
) {
}
