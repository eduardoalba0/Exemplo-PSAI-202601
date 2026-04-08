package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoSummaryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContatoMapper {

    Contato requestDTOToEntity(ContatoRequestDTO contatoRequestDTO);

    ContatoSummaryDTO entityToSummaryDTO(Contato contato);
}
