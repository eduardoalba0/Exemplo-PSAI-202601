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

    // READ - Listar todos os clientes (GET)
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = this.clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    // CREATE - Criar um novo cliente (POST)
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente request) {
        Cliente clienteSalvo = clienteService.salvar(request);
        return ResponseEntity.ok(clienteSalvo);
    }

    // UPDATE - Atualizar um cliente existente (PUT)
    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @RequestBody Cliente request){
        Cliente clienteAtualizado = clienteService.atualizar(codigo, request);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // DELETE - Excluir um cliente pelo Codigo (DELETE)
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        clienteService.excluir(codigo);
    }

    // ------------------------------------------------
    // ENDPOINTS DO CONTATO
    // ------------------------------------------------
    @PostMapping("/{codigo}/contatos")
    public ResponseEntity<Cliente> adicionarContato(@PathVariable Long codigo,
                                                    @RequestBody Contato contato){
        Cliente cliente = clienteService.adicionarContato(codigo, contato);
        return ResponseEntity.ok(cliente);
    }

}
