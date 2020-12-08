package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.dto.CategoriaDTO;
import br.com.geovanejunior.cursomc.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {

        Categoria categoria = categoriaService.findById(id);

        return ResponseEntity.ok().body(categoria);

    }

    @PostMapping
    public ResponseEntity<Void> insertCategoria(@RequestBody Categoria categoria) {

        categoria = categoriaService.insertCategoria(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizaCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {

        categoria.setId(id);

        categoria = categoriaService.updateCategoria(categoria);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {

        categoriaService.deleteCategoria(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findall() {

        List<Categoria> lista = categoriaService.findAll();
        List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);

    }

}
