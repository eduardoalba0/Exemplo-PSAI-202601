package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.endereco.Endereco;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    // Converte um DTO de requisição para a Entidade
    Endereco requestDTOToEntity(EnderecoRequestDTO enderecoRequestDTO);

    // Converte  a Entidade para  um DTO de resposta
    EnderecoResponseDTO entityToResponseDTO(Endereco endereco);

}
