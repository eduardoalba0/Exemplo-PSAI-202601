package br.edu.ifpr.bsi.projetoexemplo.repositories;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Funciona sem a anotação @Repository, mas é uma boa prática incluí-la para depuração e para indicar claramente que esta interface é um componente de acesso a dados.
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    // Método de consulta derivada para buscar clientes por nome
    List<Cliente> findByNome(String nome);

    List<Cliente> findByCpf(String cpf);

    // Usando JPQL para buscar clientes cujo nome contenha uma string
    @Query(value="SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
    List<Cliente> getAllByNomeLike(@Param("nome") String nome);

    // Usando SQL nativo para buscar clientes cujo nome contenha uma string e com limite de resultados
    @Query(nativeQuery = true, value="SELECT * FROM tb_cliente c WHERE c.nome_cliente LIKE %:nome% LIMIT :limit")
    List<Cliente> getAllByNomeLikeLimit(@Param("nome") String nome, @Param("limit") int limit);

}










