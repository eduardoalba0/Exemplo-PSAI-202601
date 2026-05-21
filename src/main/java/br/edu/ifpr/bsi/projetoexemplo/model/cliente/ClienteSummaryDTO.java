package br.edu.ifpr.bsi.projetoexemplo.model.cliente;

import br.edu.ifpr.bsi.projetoexemplo.model.endereco.EnderecoRequestDTO;

// Os DTOS de Summary representam uma versão resumida da Classe
// Eles são enviados na resposta, frequentemente dentro de outros DTOs
// Normalmente removemos também as classes relacionadas neste DTO
// Entidades fracas opcionalmente podem aparecer
// desde que sejam tomados cuidados para não estourar a pilha de execução
public record ClienteSummaryDTO(
        Long codigo,
        String nome,
        String cpf,
        String email,
        String urlImagem,
        EnderecoRequestDTO endereco
//        List<ContatoResponseDTO> contatos,
) {
}
