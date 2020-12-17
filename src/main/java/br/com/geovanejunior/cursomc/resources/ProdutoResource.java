package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Produto;
import br.com.geovanejunior.cursomc.dto.ProdutoDTO;
import br.com.geovanejunior.cursomc.resources.utils.URL;
import br.com.geovanejunior.cursomc.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> findPage(
            @RequestParam(value="nome", defaultValue = "") String nome,
            @RequestParam(value="categorias", defaultValue = "") String categorias,
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value="direction", defaultValue = "ASC") String direction) {

        String nomeDecoded = URL.decodeParam(nome);
        List<Long> ids = URL.decodeLongList(categorias);

        Page<Produto> lista = produtoService.findByNomeProduto(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
        Page<ProdutoDTO> listaDTO = lista.map(obj -> new ProdutoDTO(obj));

        return ResponseEntity.ok().body(listaDTO);

    }
}
