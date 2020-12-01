package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value="/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {

        Categoria categoria = categoriaService.buscarPorId(id);

        return ResponseEntity.ok().body(categoria);

    }

}
