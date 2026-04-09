package br.edu.ifpr.bsi.projetoexemplo.model.endereco;

public record EnderecoResponseDTO(
        Long codigo,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String cep
) {
}
