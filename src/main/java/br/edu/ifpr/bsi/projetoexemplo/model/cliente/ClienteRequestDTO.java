package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoRequestDTO;

import java.util.List;

public record ClienteRequestDTO(
        String nome,
        String email,
        String cpf,
        List<ContatoRequestDTO> contatos
) {
}
