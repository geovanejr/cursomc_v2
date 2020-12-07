package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.repositories.CategoriaRepository;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {

        Optional<Categoria> obj = categoriaRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria inserirCategoria(Categoria categoria) {

        categoria.setId(null);

        return categoriaRepository.save(categoria);

    }

    public Categoria atualizarCategoria(Categoria categoria) {

        findById(categoria.getId());

        return categoriaRepository.save(categoria);
    }
}
