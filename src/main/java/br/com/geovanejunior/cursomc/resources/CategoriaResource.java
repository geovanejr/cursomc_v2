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
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {

        Categoria categoria = categoriaService.buscarPorId(id);

        return ResponseEntity.ok().body(categoria);

    }

    @PostMapping
    public ResponseEntity<Void> insereCategoria(@RequestBody Categoria categoria) {

        categoria = categoriaService.inserirCategoria(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
