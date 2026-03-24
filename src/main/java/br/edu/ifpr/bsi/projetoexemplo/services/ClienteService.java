package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.mappers.ClienteMapper;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.cliente.ClienteResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteResponseDTO> listar() {

        List<Cliente> clientes = this.clienteRepository.findAll();

        return clientes.stream()
                .map(clienteMapper::entityToResponseDTO)
                .toList();
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO request) {
        Cliente cliente = clienteMapper.requestDTOToEntity(request);
        Cliente response = this.clienteRepository.save(cliente);
        return this.clienteMapper.entityToResponseDTO(response);
    }
}
