package br.edu.ifpr.bsi.projetoexemplo.model.endereco;

public record EnderecoSummaryDTO(
        Long codigo,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String cep
) {
}
