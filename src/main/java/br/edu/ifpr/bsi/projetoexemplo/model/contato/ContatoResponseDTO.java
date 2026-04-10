package br.edu.ifpr.bsi.projetoexemplo.model.contato;

// Os DTOs de response são enviados na resposta.
// Podem ser divididos entre Detail(detalhadoo) ou Summary (resumido)
// Caso o summary e o detail sejam iguais, você pode tratá-los apenas como Response
public record ContatoResponseDTO(
        Long id,
        String descricao,
        String telefone,
        String email,
        String whatsapp
) {
}
