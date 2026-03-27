package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
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

    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getContatos() != null && !cliente.getContatos().isEmpty()) {
            cliente.getContatos().forEach(contato-> contato.setCliente(cliente));
        }
        return this.clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long codigo, Cliente cliente){
            this.clienteRepository.findById(codigo)
                    .orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.NOT_FOUND,
                                    "Cliente não encontrado"));
        cliente.setCodigo(codigo);
        if (cliente.getContatos() != null && !cliente.getContatos().isEmpty()) {
            cliente.getContatos().forEach(contato-> contato.setCliente(cliente));
        }
        return this.clienteRepository.save(cliente);
   }

   @Transactional
   public void excluir(Long codigo){
        this.clienteRepository.findById(codigo)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
        this.clienteRepository.deleteById(codigo);
   }

    // ------------------------------------------------
    // LÓGICA DE NEGÓCIO PARA O CONTATO
    // ------------------------------------------------
    @Transactional
    public Cliente adicionarContato(Long codigoCliente, Contato contato){
        Cliente cliente = this.clienteRepository.findById(codigoCliente)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
        cliente.adicionarContato(contato);
        return this.clienteRepository.save(cliente);
    }
}
