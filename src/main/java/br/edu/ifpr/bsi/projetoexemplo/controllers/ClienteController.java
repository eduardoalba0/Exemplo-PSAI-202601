package br.edu.ifpr.bsi.projetoexemplo.controllers;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        List<ClienteResponseDTO> clientes = this.clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    // CREATE - Criar um novo cliente (POST)
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody ClienteRequestDTO request) {
        ClienteResponseDTO clienteSalvo = clienteService.salvar(request);
        return ResponseEntity.ok(clienteSalvo);
    }


}
