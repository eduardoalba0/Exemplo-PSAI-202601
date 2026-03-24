package br.edu.ifpr.bsi.projetoexemplo.model.produto;

public record ProdutoRequestDTO(
        String nome,
        String descricao,
        Double preco
) {
}
