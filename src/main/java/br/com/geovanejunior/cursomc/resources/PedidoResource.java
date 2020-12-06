package br.com.geovanejunior.cursomc.resources;

import br.com.geovanejunior.cursomc.domain.Pedido;
import br.com.geovanejunior.cursomc.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    
    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        Pedido pedido = pedidoService.buscarPorId(id);
        return ResponseEntity.ok().body(pedido);
    }
}
