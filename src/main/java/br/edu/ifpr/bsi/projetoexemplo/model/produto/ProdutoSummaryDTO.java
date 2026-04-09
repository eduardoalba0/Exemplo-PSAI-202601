package br.edu.ifpr.bsi.projetoexemplo.model.produto;


public record ProdutoSummaryDTO(
        Long codigo,
        String nome,
        String descricao,
        Double preco
) {
}
