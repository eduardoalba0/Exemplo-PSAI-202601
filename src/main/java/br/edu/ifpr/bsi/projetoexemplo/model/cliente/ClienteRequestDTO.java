package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoRequestDTO;

import java.util.List;

// O DTO de request serve para definir o formato da requisição
// REQUISIÇÃO é quando a gente está recebendo um conjunto de dados
public record ClienteRequestDTO(
        String nome,
        String cpf,
        String email,
        String senha,
        // Colocamos o DTO de Request de endereço e contato
        // pois vamos inserir todos juntos
        EnderecoRequestDTO endereco,
        List<ContatoRequestDTO> contatos
) {
}
