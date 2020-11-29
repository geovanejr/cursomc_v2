package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @GetMapping
    public List<Categoria> listar() {

        Categoria cat1 = new Categoria(1L,"Informática", LocalDateTime.now().toInstant(ZoneOffset.UTC));
        Categoria cat2 = new Categoria(2L, "Escritório", LocalDateTime.now().toInstant(ZoneOffset.UTC));

        List<Categoria> lista = new ArrayList<>();

        lista.addAll(Arrays.asList(cat1, cat2));

        return lista;
    }

}
