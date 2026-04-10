package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import java.util.List;

public record PedidoRequestDTO(
        String descricao,
        Long clienteCodigo,
        List<Long> codigosProdutos
) {
}
