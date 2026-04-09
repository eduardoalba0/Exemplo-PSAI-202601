package br.edu.ifpr.bsi.projetoexemplo.model.funcionario;

public record FuncionarioSummaryDTO(
        Long codigo,
        String matricula,
        Long usuarioId
) {
}
