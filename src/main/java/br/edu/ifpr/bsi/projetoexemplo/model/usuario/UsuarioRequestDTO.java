package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

public record UsuarioRequestDTO(
        String username,
        String password,
        String role
) {
}
