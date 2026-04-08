package br.edu.ifpr.bsi.projetoexemplo.model.endereco;

public record EnderecoRequestDTO(
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String cep
) {
}
