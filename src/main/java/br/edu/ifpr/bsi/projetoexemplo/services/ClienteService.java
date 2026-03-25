package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        if (cliente.getContatos()!= null && !cliente.getContatos().isEmpty()){
            cliente.getContatos().forEach(contato -> contato.setCliente(cliente));
        }
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }

    public List<Cliente> listarPorNome(String nome) {
        return this.clienteRepository.getAllByNomeLike(nome);
    }

    public Cliente obterPorId(Long codigo) {
        Cliente clienteEncontrado = this.clienteRepository.findById(codigo).orElse(null);
        if (clienteEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        return clienteEncontrado;
    }

    @Transactional
    public Cliente salvar(Long codigo, Cliente cliente) {
        Cliente clienteEncontrado = this.clienteRepository.findById(codigo).orElse(null);
        if (clienteEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        cliente.setCodigo(codigo);
        return this.clienteRepository.save(cliente);
    }



    @Transactional
    public void excluir(Long clienteId) {
        this.clienteRepository.deleteById(clienteId);
    }

}
