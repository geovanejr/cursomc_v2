package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Cidade;
import br.com.geovanejunior.cursomc.domain.Estado;
import br.com.geovanejunior.cursomc.dto.CidadeDTO;
import br.com.geovanejunior.cursomc.dto.EstadoDTO;
import br.com.geovanejunior.cursomc.service.CidadeService;
import br.com.geovanejunior.cursomc.service.EstadoService;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll() {

        List<Estado> lista = estadoService.findAllEstado();
        List<EstadoDTO> listaDTO = lista.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }
    
    @GetMapping(value = "{estadoId}/cidades")
    public ResponseEntity<List<CidadeDTO>> findAllCidade(@PathVariable Long estadoId) {

        List<Cidade> lista = cidadeService.findByEstado(estadoId);

        if (lista.size() == 0) {
            Estado estado = estadoService.findById(estadoId);
            throw new ObjectNotFoundException("Não há cidades cadastradas para o Estado : " + estado.getNome());
        }

        List<CidadeDTO> listaDTO = lista.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }
}
