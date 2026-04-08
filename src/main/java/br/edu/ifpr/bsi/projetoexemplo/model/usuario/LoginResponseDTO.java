package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

public record LoginResponseDTO(
        UsuarioDetailDTO usuario,
        String token
) {
    public LoginResponseDTO(UsuarioDetailDTO usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }
}
