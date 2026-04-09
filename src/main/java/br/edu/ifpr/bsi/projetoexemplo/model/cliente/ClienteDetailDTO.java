package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioSummaryDTO;

import java.util.List;

public record ClienteDetailDTO(
        Long codigo,
        String nome,
        String email,
        String cpf,
        UsuarioSummaryDTO usuario,
        EnderecoResponseDTO endereco,
        List<ContatoResponseDTO> contatos,
        List<PedidoSummaryDTO> pedidos
) {
}
