package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping(value="/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        Cliente cliente = clienteService.buscarPorId(id);

        return ResponseEntity.ok().body(cliente);
    }

}
