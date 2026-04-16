package br.edu.ifpr.bsi.projetoexemplo.model.produto;


import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoSummaryDTO;

import java.util.List;

public record ProdutoDetailDTO(
        Long codigo,
        String nome,
        String descricao,
        Double preco,
        List<PedidoSummaryDTO> pedidosProduto
) {
}
