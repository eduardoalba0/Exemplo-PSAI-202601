package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.produto.Produto;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.produto.ProdutoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // Converte um DTO de requisição para a Entidade
    Produto requestDTOToEntity(ProdutoRequestDTO produtoRequestDTO);

    // Converte  a Entidade para  um DTO de resposta
    ProdutoResponseDTO entityToResponseDTO(Produto produto);

}
