package br.edu.ifpr.bsi.projetoexemplo.model.usuario;

public record LoginRequestDTO(
        String username,
        String password
) {
    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
