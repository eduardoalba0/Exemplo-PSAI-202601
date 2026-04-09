package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.endereco.Endereco;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco requestDTOToEntity(EnderecoRequestDTO enderecoRequestDTO);

    EnderecoResponseDTO entityToResponseDTO(Endereco endereco);
}
