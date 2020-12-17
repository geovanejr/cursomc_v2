package br.com.geovanejunior.cursomc.repositories;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT DISTINCT obj FROM Produto obj " +
            "INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")

    Page<Produto> findByNomeProduto(@Param("nome") String nome, @Param("categorias") List<Categoria> listaCategoria, Pageable pageRequest);

//    Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
