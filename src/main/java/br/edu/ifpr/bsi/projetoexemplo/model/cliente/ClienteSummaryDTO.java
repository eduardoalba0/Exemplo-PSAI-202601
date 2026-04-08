package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

public record ClienteSummaryDTO(
        Long codigo,
        String nome,
        String email,
        String cpf,
        Long usuarioId
) {
}
