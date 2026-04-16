package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoRequestDTO(
        String descricao,
        LocalDateTime data,
        Long clienteId,
        List<Long> produtosId
) {
}
