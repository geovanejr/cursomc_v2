package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.dto.ClienteDTO;
import br.com.geovanejunior.cursomc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Cliente> findPorId(@PathVariable Long id) {

        Cliente cliente = clienteService.findById(id);

        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> atualizaCliente(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Long id) {

        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setId(id);

        cliente = clienteService.updateCliente(cliente);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {

        clienteService.deleteCliente(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findall() {

        List<Cliente> lista = clienteService.findAllCliente();
        List<ClienteDTO> listaDTO = lista.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);

    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value="page", defaultValue = "0") Integer page,
                                                       @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                       @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
                                                       @RequestParam(value="direction", defaultValue = "ASC") String direction) {

        Page<Cliente> lista = clienteService.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listaDTO = lista.map(obj -> new ClienteDTO(obj));

        return ResponseEntity.ok().body(listaDTO);

    }

}
