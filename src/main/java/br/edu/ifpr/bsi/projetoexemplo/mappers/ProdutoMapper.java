package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.Produto;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoSummaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PedidoMapper.class})
public interface ProdutoMapper {

    Produto requestDTOToEntity(ProdutoRequestDTO produtoRequestDTO);

    ProdutoDetailDTO entityToDetailDTO(Produto produto);

    @Mapping(source="pedidosProduto", target="pedidosId")
    ProdutoSummaryDTO entityToSummaryDTO(Produto produto);

    default Long toCodigo(Pedido pedido){
        return pedido.getCodigo();
    }

}
