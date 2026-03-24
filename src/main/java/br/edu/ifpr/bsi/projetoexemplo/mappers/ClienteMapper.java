package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ContatoMapper.class, EnderecoMapper.class})
public interface ClienteMapper {

    // Converte um DTO de requisição para a Entidade
    Cliente requestDTOToEntity(ClienteRequestDTO clienteRequestDTO);

    // Converte  a Entidade para  um DTO de resposta
    ClienteResponseDTO entityToResponseDTO(Cliente cliente);

}
