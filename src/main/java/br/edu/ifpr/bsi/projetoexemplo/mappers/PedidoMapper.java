package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.pedido.Pedido;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    // Converte um DTO de requisição para a Entidade
    Pedido requestDTOToEntity(PedidoRequestDTO pedidoRequestDTO);

    // Converte  a Entidade para  um DTO de resposta
    PedidoResponseDTO entityToResponseDTO(Pedido endereco);

}
