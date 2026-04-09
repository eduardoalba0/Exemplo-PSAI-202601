package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.pedido.PedidoSummaryDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioDetailDTO;

import java.util.List;

public record ClienteDetailDTO(
        Long codigo,
        String nome,
        String email,
        String cpf,
        String username,
        String role,
        EnderecoSummaryDTO endereco,
        List<ContatoSummaryDTO> contatos,
        List<PedidoSummaryDTO> pedidos
) implements UsuarioDetailDTO {
}
