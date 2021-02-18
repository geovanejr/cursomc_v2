package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.dto.CategoriaDTO;
import br.com.geovanejunior.cursomc.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation(value="Pesquisa categoria por Id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {

        Categoria categoria = categoriaService.findById(id);

        return ResponseEntity.ok().body(categoria);

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value="Inserção de nova categoria")
    @PostMapping
    public ResponseEntity<Void> insertCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {

        Categoria categoria = categoriaService.fromDTO(categoriaDTO);

        categoria = categoriaService.insertCategoria(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizaCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id) {

        Categoria categoria = categoriaService.fromDTO(categoriaDTO);

        categoria.setId(id);

        categoria = categoriaService.updateCategoria(categoria);

        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
            @ApiResponse(code = 404, message = "Categoria inexistente") })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {

        categoriaService.deleteCategoria(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findall() {

        List<Categoria> lista = categoriaService.findAllCategoria();
        List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);

    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value="page", defaultValue = "0") Integer page,
                                                       @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                       @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
                                                       @RequestParam(value="direction", defaultValue = "ASC") String direction) {

        Page<Categoria> lista = categoriaService.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoriaDTO> listaDTO = lista.map(obj -> new CategoriaDTO(obj));

        return ResponseEntity.ok().body(listaDTO);

    }

}
