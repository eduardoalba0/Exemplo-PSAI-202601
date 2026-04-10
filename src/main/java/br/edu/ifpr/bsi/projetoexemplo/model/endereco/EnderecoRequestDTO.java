package br.edu.ifpr.bsi.projetoexemplo.model.endereco;

public record EnderecoRequestDTO(
        String cep,
        String logradouro,
        String bairro,
        String numero,
        String cidade
) {
}
