package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.enums.Role;
import br.edu.ifpr.bsi.projetoexemplo.mappers.ClienteMapper;
import br.edu.ifpr.bsi.projetoexemplo.mappers.ContatoMapper;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.ContatoRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ContatoMapper contatoMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public ClienteDetailDTO salvar(ClienteRequestDTO request) {
        Cliente cliente = this.clienteMapper.requestDTOToEntity(request);
        if (cliente.getContatos() != null && !cliente.getContatos().isEmpty()) {
            cliente.getContatos().forEach(contato -> contato.setCliente(cliente));
        }
        cliente.setPassword(this.passwordEncoder.encode(cliente.getPassword()));
        return this.clienteMapper.entityToDetailDTO(this.clienteRepository.save(cliente));
    }

    public List<ClienteDetailDTO> listar() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this.clienteMapper::entityToDetailDTO)
                .toList();
    }

    public List<ClienteDetailDTO> listarPorNome(String nome) {
        List<Cliente> clientes = clienteRepository.getAllByNomeLike(nome);
        return clientes.stream()
                .map(this.clienteMapper::entityToDetailDTO)
                .toList();
    }

    public ClienteDetailDTO obterPorId(Long codigo) {
        Cliente clienteEncontrado = this.clienteRepository.findById(codigo).orElse(null);
        if (clienteEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        return this.clienteMapper.entityToDetailDTO(clienteEncontrado);
    }

    @Transactional
    public ClienteDetailDTO atualizar(Long codigo, ClienteRequestDTO request) {
        this.clienteRepository.findById(codigo).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        Cliente cliente = this.clienteMapper.requestDTOToEntity(request);
        cliente.setCodigo(codigo);

        if (cliente.getPassword() != null) {
            cliente.setPassword(this.passwordEncoder.encode(cliente.getPassword()));
        }

        return this.clienteMapper.entityToDetailDTO(this.clienteRepository.save(cliente));
    }

    @Transactional
    public void excluir(Long codigo) {
        this.clienteRepository.findById(codigo).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        this.clienteRepository.deleteById(codigo);
    }

    @Transactional
    public ClienteDetailDTO adicionarContato(Long codigoCliente, ContatoRequestDTO request) {
        Cliente clienteEncontrado = this.clienteRepository.findById(codigoCliente).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        Contato contato = this.contatoMapper.requestDTOToEntity(request);
        clienteEncontrado.adicionarContato(contato);
        return this.clienteMapper.entityToDetailDTO(this.clienteRepository.save(clienteEncontrado));
    }

}
