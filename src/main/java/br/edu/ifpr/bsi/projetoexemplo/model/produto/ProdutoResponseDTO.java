package br.edu.ifpr.bsi.projetoexemplo.model.produto;


public record ProdutoResponseDTO(
        Long codigo,
        String nome,
        String descricao,
        Double preco
) {
}
