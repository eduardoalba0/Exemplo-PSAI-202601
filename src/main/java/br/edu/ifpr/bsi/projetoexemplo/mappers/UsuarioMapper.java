package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.Usuario;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioSummaryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, FuncionarioMapper.class})
public interface UsuarioMapper {

    Usuario requestDTOToEntity(UsuarioRequestDTO usuarioRequestDTO);

    UsuarioDetailDTO entityToDetailDTO(Usuario usuario);

    UsuarioSummaryDTO entityToSummaryDTO(Usuario usuario);
}
