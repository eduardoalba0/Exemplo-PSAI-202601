package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

public record UsuarioSummaryDTO(
        Long codigo,
        String username,
        String role
) {
}
