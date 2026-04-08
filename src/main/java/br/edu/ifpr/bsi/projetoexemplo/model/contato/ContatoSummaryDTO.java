package br.edu.ifpr.bsi.projetoexemplo.model.contato;

public record ContatoSummaryDTO(
        Long codigo,
        String telefone,
        String email,
        String whatsapp
) {
}
