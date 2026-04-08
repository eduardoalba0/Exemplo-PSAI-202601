package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface PedidoMapper {

    Pedido requestDTOToEntity(PedidoRequestDTO pedidoRequestDTO);

    PedidoDetailDTO entityToDetailDTO(Pedido pedido);

    @Mapping(source = "cliente.codigo", target = "clienteId")
    @Mapping(source = "produtosPedido", target = "produtosId")
    PedidoSummaryDTO entityToSummaryDTO(Pedido pedido);

    default Long toCodigo(Produto produto){
        return produto.getCodigo();
    }
}
