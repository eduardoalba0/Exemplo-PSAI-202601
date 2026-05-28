package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoSummaryDTO;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDetailDTO(
        Long codigo,
        String descricao,
        LocalDateTime data,
        List<ProdutoSummaryDTO> produtosPedido
) {
}
