package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(
        Long codigo,
        String descricao,
        LocalDateTime data,
        ClienteResponseDTO cliente,
        List<ProdutoResponseDTO> produtos
) {
}
