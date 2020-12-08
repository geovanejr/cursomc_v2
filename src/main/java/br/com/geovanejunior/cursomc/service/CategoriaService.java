package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.repositories.CategoriaRepository;
import br.com.geovanejunior.cursomc.service.exceptions.DataIntegrityException;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Categoria insertCategoria(Categoria categoria) {

        categoria.setId(null);

        return categoriaRepository.save(categoria);

    }

    public Categoria updateCategoria(Categoria categoria) {

        findById(categoria.getId());

        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {

        findById(id);

        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria com produtos atrelados!");
        }
    }

    public List<Categoria> findAllCategoria() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return categoriaRepository.findAll(pageRequest);

    }
}
