package br.edu.ifpr.bsi.projetoexemplo.repositories;

import br.edu.ifpr.bsi.projetoexemplo.model.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

// Funciona sem a anotação @Repository, mas é uma boa prática incluí-la para depuração e para indicar claramente que esta interface é um componente de acesso a dados.
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    // Método de consulta derivada para buscar clientes por nome
    List<Cliente> findByNome(String nome);

    List<Cliente> findByCpf(String cpf);

    // Usando JPQL para buscar clientes cujo nome contenha uma string
    @Query(value="SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE UPPER(CONCAT('%',:nome, '%'))")
    List<Cliente> getAllByNomeLike(@Param("nome") String nome);

    // Usando SQL nativo para buscar clientes cujo nome contenha uma string e com limite de resultados
    @Query(nativeQuery = true, value="SELECT * FROM tb_cliente c WHERE c.nome_cliente LIKE %:nome% LIMIT :limit")
    List<Cliente> getAllByNomeLikeLimit(@Param("nome") String nome, @Param("limit") int limit);

    // Usando JPQL com filtros combinados
    @Query("SELECT DISTINCT c FROM Cliente c " +
            "LEFT JOIN c.pedidos p " + // JOIN com pedidos - LEFT para pegar clientes que não fizeram pedidos
            "WHERE "+
            "(:nome IS NULL OR UPPER(c.nome) LIKE UPPER(CONCAT('%', CAST(:nome AS STRING), '%'))) AND "+
            "(:cpf IS NULL OR c.cpf LIKE CONCAT('%',CAST(:cpf AS STRING), '%')) AND "+
            "(CAST(:dataInicioPedido AS LocalDateTime) IS NULL OR p.dataPedido >= :dataInicioPedido) AND " +
            "(CAST(:dataFimPedido AS LocalDateTime) IS NULL OR p.dataPedido <= :dataFimPedido)")
    Page<Cliente> findAllByQuery
        (@Param("nome") String nome,
         @Param("cpf") String cpf,
         @Param("dataInicioPedido") LocalDateTime dataInicioPedido,
         @Param("dataFimPedido") LocalDateTime dataFimPedido,
         Pageable pageable);

}










