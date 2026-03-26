package br.edu.ifpr.bsi.projetoexemplo.controllers;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // ==========================================================
    // ENDPOINTS DE CLIENTE
    // ==========================================================

    // CREATE - Criar um novo cliente (POST)
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente request) {
        Cliente clienteSalvo = clienteService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    // READ - Listar todos os clientes (GET)
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = this.clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    // READ - Listar todos os clientes filtrando-os pelo nome (GET)
    // Não é recomendado criar um endpoint específico para cada tipo de filtro, o ideal é criar um endpoint genérico de listagem e usar parâmetros de consulta (query parameters) para aplicar os filtros desejados. Assim, o mesmo endpoint pode ser usado para listar todos os clientes ou para listar clientes filtrados por nome, por exemplo.
    @GetMapping("/listar-nome")
    public ResponseEntity<List<Cliente>> listarClientesPorNome(
            @RequestParam String nome) {
        List<Cliente> clientes = this.clienteService.listarPorNome(nome);
        return ResponseEntity.ok(clientes);
    }

    // READ - Obter um cliente pelo Codigo (GET)
    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> obterPorCodigo(@PathVariable Long codigo) {
        Cliente cliente = this.clienteService.obterPorId(codigo);
        return ResponseEntity.ok(cliente);
    }

    // UPDATE - Atualizar um cliente existente pelo Codigo (PUT - atualização completa)
    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @RequestBody Cliente request) {
        Cliente clienteAtualizado = clienteService.atualizar(codigo, request);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // DELETE - Excluir um cliente pelo Codigo (DELETE)
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo) {
        clienteService.excluir(codigo);
    }

    // ==========================================================
    // ENDPOINTS DO CONTATO DO CLIENTE
    // ==========================================================

    // CREATE - Criar um novo contato para um cliente específico (POST)
    @PostMapping("/{codigoCliente}/contatos")
    public ResponseEntity<Cliente> adicionarContato(@PathVariable Long codigoCliente, @RequestBody Contato request) {
        Cliente cliente = clienteService.adicionarContato(codigoCliente, request);
        return ResponseEntity.ok(cliente);
    }

    /**
     * TODO - Implementar restante dos endpoints de contato, se necessário.
     */
}
