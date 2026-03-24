package br.edu.ifpr.bsi.projetoexemplo.controllers;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = this.clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    // CREATE - Criar um novo cliente (POST)
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente request) {
        if (request.getCodigo() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Atualização permitida somente através do método PUT.");
        }
        Cliente clienteSalvo = clienteService.salvar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteSalvo.getCodigo())
                .toUri();

        return ResponseEntity.created(uri).body(clienteSalvo);
    }


}
