package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioRequestDTO;

import java.util.List;

public record ClienteRequestDTO(
        String nome,
        String email,
        String cpf,
        UsuarioRequestDTO usuario,
        List<ContatoRequestDTO> contatos
) {
}
