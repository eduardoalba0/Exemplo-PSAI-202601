package br.edu.ifpr.bsi.projetoexemplo.model.endereco;

public record EnderecoResponseDTO(
        Long codigo,
        String cep,
        String logradouro,
        String bairro,
        String numero,
        String cidade
) {
}
