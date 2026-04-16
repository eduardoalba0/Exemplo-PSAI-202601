package br.edu.ifpr.bsi.projetoexemplo.model.contato;

public record ContatoRequestDTO(
        String telefone,
        String email,
        String whatsapp
) {
}
