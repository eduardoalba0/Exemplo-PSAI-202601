package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContatoMapper {

    // Converte um DTO de requisição para a Entidade
    Contato requestDTOToEntity(ContatoRequestDTO contatoRequestDTO);

    // Converte  a Entidade para  um DTO de resposta
    ContatoResponseDTO entityToResponseDTO(Contato contato);

}
