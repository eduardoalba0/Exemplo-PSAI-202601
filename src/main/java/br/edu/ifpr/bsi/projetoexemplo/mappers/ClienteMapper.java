package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteSummaryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ContatoMapper.class, EnderecoMapper.class})
public interface ClienteMapper {

    // Converte um DTO de requisição para a Entidade
    Cliente requestDTOToEntity(ClienteRequestDTO clienteRequestDTO);

    // Converte  a Entidade para  um DTO de resposta detalhada (Detail)
    ClienteDetailDTO entityToDetailDTO(Cliente cliente);

    // Converte  a Entidade para  um DTO de resposta resumida (Summary)
    ClienteSummaryDTO entityToSummaryDTO(Cliente cliente);

}
