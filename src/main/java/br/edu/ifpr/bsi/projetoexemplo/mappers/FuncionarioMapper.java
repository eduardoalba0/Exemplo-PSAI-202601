package br.edu.ifpr.bsi.projetoexemplo.mappers;

import br.edu.ifpr.bsi.projetoexemplo.model.funcionario.Funcionario;
import br.edu.ifpr.bsi.projetoexemplo.model.funcionario.FuncionarioDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.funcionario.FuncionarioRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.funcionario.FuncionarioSummaryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    Funcionario requestDTOToEntity(FuncionarioRequestDTO funcionarioRequestDTO);

    FuncionarioDetailDTO entityToDetailDTO(Funcionario funcionario);

    FuncionarioSummaryDTO entityToSummaryDTO(Funcionario funcionario);
}
