package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Categoria categoria = categoriaService.findById(id);

        return ResponseEntity.ok().body(categoria);

    }

    @PostMapping
    public ResponseEntity<Void> insereCategoria(@RequestBody Categoria categoria) {

        categoria = categoriaService.inserirCategoria(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizaCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {

        categoria.setId(id);

        categoria = categoriaService.atualizarCategoria(categoria);

        return ResponseEntity.noContent().build();
    }

}
