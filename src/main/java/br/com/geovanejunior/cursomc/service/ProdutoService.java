package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.domain.Produto;
import br.com.geovanejunior.cursomc.repositories.CategoriaRepository;
import br.com.geovanejunior.cursomc.repositories.ProdutoRepository;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto buscarPorId(Long id) {

        Optional<Produto> obj = produtoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<Produto> findByNomeProduto (String nome, List<Long> ids, Integer page, Integer linesPerPage,
                                            String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        List<Categoria> listaCategoria = categoriaRepository.findAllById(ids);

        return produtoRepository.findByNomeProduto(nome, listaCategoria, pageRequest);
    }
}