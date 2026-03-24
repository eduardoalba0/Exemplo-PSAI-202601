package br.edu.ifpr.bsi.projetoexemplo.model.contato;

public record ContatoResponseDTO(
        Long codigo,
        String telefone,
        String email,
        String whatsapp
) {
}
