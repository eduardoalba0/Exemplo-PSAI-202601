package br.edu.ifpr.bsi.projetoexemplo.controllers;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

//    // READ - Listar todos os clientes (GET)
//    @GetMapping
//    public ResponseEntity<List<Cliente>> listar() {
//        List<Cliente> clientes = this.clienteService.listar();
//        return ResponseEntity.ok(clientes);
//    }

//    // READ - Listar todos os clientes com filtro por ExampleMatcher (GET)
//    @GetMapping
//    public ResponseEntity<List<Cliente>> listarExampleMatcher(@ModelAttribute Cliente cliente) {
//        List<Cliente> clientes = this.clienteService.listarExampleMatcher(cliente);
//        return ResponseEntity.ok(clientes);
//    }

    // READ - Listar todos os clientes (GET)
    @GetMapping
    public ResponseEntity<Page<Cliente>> listarQuery(@RequestParam(name="nome", required = false) String nome,
                                                     @RequestParam(name="cpf", required = false) String cpf,
                                                     @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @RequestParam(name="dataInicioPedido", required = false) LocalDateTime dataInicioPedido,
                                                     @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @RequestParam(name="dataFimPedido", required = false) LocalDateTime dataFimPedido,
                                                     @PageableDefault(page=0, size=10, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Cliente> clientes = this.clienteService.listarQuery(nome,
                cpf,
                dataInicioPedido,
                dataFimPedido,
                pageable);
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
