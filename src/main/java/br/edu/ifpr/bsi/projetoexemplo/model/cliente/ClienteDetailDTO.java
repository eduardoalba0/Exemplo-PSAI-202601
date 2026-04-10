package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoSummaryDTO;

import java.util.List;

// Os DTOs de Detail são aqueles que possuem mais detalhes,
// ou seja, possuem mais informações do que os Summary
// Eles são enviados na resposta, no endpoint principal da classe representada
// por isso, precisam ter todas as informações e relacionamentos necessários
public record ClienteDetailDTO(
        Long codigo,
        String nome,
        String cpf,
        String email,
        // Quando temos um DTO relacionado
        // O que está dentro normalmente será o "Summary"
        EnderecoResponseDTO endereco,
        List<ContatoResponseDTO> contatos,
        List<PedidoSummaryDTO> pedidos
) {
}
