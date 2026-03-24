package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoResponseDTO;

import java.util.List;

public record ClienteResponseDTO(
        Long codigo,
        String nome,
        String email,
        String cpf,
        List<ContatoResponseDTO> contatos
) {
}
