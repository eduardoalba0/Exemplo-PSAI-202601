package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import java.time.LocalDateTime;

public record PedidoSummaryDTO(
        Long codigo,
        LocalDateTime dataPedido,
        String descricao
) {
}
