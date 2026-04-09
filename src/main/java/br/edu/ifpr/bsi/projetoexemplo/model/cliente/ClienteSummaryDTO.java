package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioSummaryDTO;

public record ClienteSummaryDTO(
        Long codigo,
        String nome,
        String email,
        String cpf,
        String username,
        String role
) implements UsuarioSummaryDTO {
}
