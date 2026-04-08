package br.edu.ifpr.bsi.projetoexemplo.model.produto;


import java.util.List;

public record ProdutoSummaryDTO(
        Long codigo,
        String nome,
        String descricao,
        Double preco,
        List<Long> pedidosId
) {
}
