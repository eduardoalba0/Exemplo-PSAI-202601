package br.edu.ifpr.bsi.projetoexemplo.repositories;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import br.edu.ifpr.bsi.projetoexemplo.model.contato.Contato;
import br.edu.ifpr.bsi.projetoexemplo.model.endereco.Endereco;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional // Garante que cada teste seja executado em uma transação separada, e que as alterações feitas no banco de dados durante os testes sejam revertidas após a execução de cada teste, mantendo o banco de dados limpo para os próximos testes.
class ClienteRepositoryTest {

    @Autowired // Autowired vai injetar uma instancia real do ClienteRepository
    private ClienteRepository clienteRepository;

    // Teste com os métodos já implementados no ClienteRepository, que são herdados do JpaRepository
    @Test
    public void testInsert() {
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setCpf("12345678900");
        cliente = clienteRepository.save(cliente);

        Cliente clienteInserido = clienteRepository.findById(cliente.getCodigo()).get();

        Assertions.assertNotNull(clienteInserido, "O cliente não foi inserido.");
    }

    @Test
    public void testUpdate() {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        cliente.setCpf("98765432100");
        // O resultado do save é um cliente com seu código gerado pelo DB
        Cliente clienteAlterar = clienteRepository.save(cliente);

        clienteAlterar.setNome("Maria Silva");
        // O save é usado tanto para inserir quanto para atualizar,
        clienteAlterar = clienteRepository.save(clienteAlterar);

        Cliente clienteAlterado = clienteRepository.findById(clienteAlterar.getCodigo()).get();

        Assertions.assertEquals("Maria Silva", clienteAlterado.getNome(), "O nome o cliente não foi atualizado.");
    }

    @Test
    public void testDelete() {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        cliente.setCpf("98765432100");
        Cliente clienteDeletar = clienteRepository.save(cliente);
        clienteRepository.delete(clienteDeletar);

        Cliente clienteDeletado = clienteRepository.findById(cliente.getCodigo()).orElse(null);
        Assertions.assertNull(clienteDeletado, "O cliente ainda encontra-se no banco de dados.");
    }


    // Consulta com teste de tempo de execução (mede a performance - RNF)
    @Test
    public void testListar() {
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos");
        cliente.setCpf("111.222.333-44");
        clienteRepository.save(cliente);

        long inicio = System.currentTimeMillis();
        List<Cliente> clientes = clienteRepository.findAll();
        long fim = System.currentTimeMillis();

        Assertions.assertFalse(clientes.isEmpty(), "A consulta não retornou resultados.");
        Assertions.assertTrue((fim - inicio) < 300, "A consulta demorou mais de 0,3 segundos");
    }

    // Teste dos métodos que colocamos na interface ClienteRepository
    @Test
    public void testFindByNome() {
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos");
        cliente.setCpf("111.222.333-44");

        clienteRepository.save(cliente);

        List<Cliente> clientes = clienteRepository.findByNome("Carlos");
        Assertions.assertFalse(clientes.isEmpty(), "Nenhum cliente encontrado com o nome especificado.");

    }

    @Test
    public void testGetAllByNomeLike() {
        Cliente cliente = new Cliente();
        cliente.setNome("Eduardo");
        cliente.setCpf("111.222.333-44");

        clienteRepository.save(cliente);

        List<Cliente> clientes = clienteRepository.getAllByNomeLike("Edu");
        Assertions.assertFalse(clientes.isEmpty(), "Nenhum cliente encontrado com o nome especificado.");
    }

    @Test
    public void testGetAllByNomeLikeLimit() {
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Cliente cliente = new Cliente();
            cliente.setNome("Luiz " + i);
            cliente.setCpf("111.222.333-4" + i);
            clientes.add(cliente);
        }
        clienteRepository.saveAll(clientes);

        List<Cliente> clientesEncontrados = clienteRepository.getAllByNomeLikeLimit("Lu", 10);
        Assertions.assertFalse(clientesEncontrados.isEmpty(), "Nenhum cliente encontrado com o nome especificado.");
        Assertions.assertEquals(10, clientesEncontrados.size(), "O número de clientes encontrados não corresponde ao limite definido.");
    }

    // ------------------- Inserção com Relacionamentos -------------------
    @Test
    public void testInserirContato() {
        Cliente cliente = new Cliente();
        cliente.setNome("Leticia Laumann");
        cliente.setCpf("555.666.777-88");

        List<Contato> contatos = new ArrayList<>();
        Contato contato1 = new Contato();
        contato1.setEmail("larissa@gmail.com");
        contato1.setWhatsapp("+55(46)99999-9999");
        contato1.setTelefone("+55(46)99999-9999");
        contato1.setCliente(cliente);
        contatos.add(contato1);

        Contato contato2 = new Contato();
        contato2.setEmail("ana@hotmail.com");
        contato2.setWhatsapp("+55(46)88888-8888");
        contato2.setTelefone("+55(46)88888-8888");
        contato2.setCliente(cliente);
        contatos.add(contato2);

        cliente.setContatos(contatos);
        Cliente clienteInserir = clienteRepository.save(cliente);
        Cliente clienteInserido = clienteRepository.findById(clienteInserir.getCodigo()).get();
        Assertions.assertNotNull(clienteInserido.getContatos());
        Assertions.assertFalse(clienteInserido.getContatos().isEmpty(), "Os contatos do cliente não foram inseridos corretamente.");

    }

    @Test
    public void testInserirEndereco() {
        Cliente cliente = new Cliente();
        cliente.setNome("Gabriela Fogaça");
        cliente.setCpf("555.666.777-88");

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua das Flores");
        endereco.setNumero("123");
        endereco.setCep("85555-000");

        cliente.setEndereco(endereco);
        Cliente clienteInserir = clienteRepository.save(cliente);

        Cliente clienteInserido = clienteRepository.findById(clienteInserir.getCodigo()).get();
        Assertions.assertNotNull(clienteInserido.getEndereco(), "O endereço do cliente não foi inserido corretamente.");
    }
}
