package br.edu.ifpr.bsi.projetoexemplo.model.pedido;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoRequestDTO(
        String descricao,
        LocalDateTime data,
        ClienteRequestDTO cliente,
        List<ProdutoRequestDTO> produtos
) {
}
