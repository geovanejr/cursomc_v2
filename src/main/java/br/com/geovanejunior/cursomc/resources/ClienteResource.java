package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.dto.ClienteDTO;
import br.com.geovanejunior.cursomc.dto.ClienteNewDTO;
import br.com.geovanejunior.cursomc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping(value="/email")
    public ResponseEntity<Cliente> findPorEmail(@Valid @RequestParam(value = "value") String email) {

        Cliente cliente = clienteService.findByEmail(email);

        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<Void> insertCliente(@Valid @RequestBody ClienteNewDTO clienteNewDTO) {

        Cliente cliente = clienteService.fromDTO(clienteNewDTO);

        cliente = clienteService.insertCliente(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value="/{id}")
    public ResponseEntity<Void> atualizaCliente(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Long id) {

        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setId(id);

        cliente = clienteService.updateCliente(cliente);

        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {

        clienteService.deleteCliente(id);

        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findall() {

        List<Cliente> lista = clienteService.findAllCliente();
        List<ClienteDTO> listaDTO = lista.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value="/page")
    public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value="page", defaultValue = "0") Integer page,
                                                       @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                       @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
                                                       @RequestParam(value="direction", defaultValue = "ASC") String direction) {

        Page<Cliente> lista = clienteService.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listaDTO = lista.map(obj -> new ClienteDTO(obj));

        return ResponseEntity.ok().body(listaDTO);

    }

    @PostMapping(value="/picture")
    public ResponseEntity<Void> uploadProfilePicture(@RequestParam(value = "file") MultipartFile multipartFile) {

        URI uri = clienteService.uploadProfilePicture(multipartFile);

        return ResponseEntity.created(uri).build();
    }

}
