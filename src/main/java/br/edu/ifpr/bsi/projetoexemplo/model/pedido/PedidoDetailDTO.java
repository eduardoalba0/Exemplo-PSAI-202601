package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoSummaryDTO;

import java.time.LocalDateTime;
import java.util.List;

// Os DTOs de Detail são aqueles que possuem mais detalhes,
// ou seja, possuem mais informações do que os Summary
// Eles são enviados na resposta.
public record PedidoDetailDTO(
        Long codigo,
        LocalDateTime dataPedido,
        String descricao,
        ClienteSummaryDTO cliente,
        List<ProdutoSummaryDTO> produtos
) {
}
