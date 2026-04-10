package br.edu.ifpr.bsi.projetoexemplo.model.produto;

import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoSummaryDTO;

import java.util.List;

// Os DTOs de Detail são aqueles que possuem mais detalhes,
// ou seja, possuem mais informações do que os Summary
// Eles são enviados na resposta.
public record ProdutoDetailDTO(
        Long codigo,
        String nome,
        String descricao,
        Double preco,
        List<PedidoSummaryDTO> pedidos
) {
}
