package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.domain.Pedido;
import br.com.geovanejunior.cursomc.repositories.PedidoRepository;
import br.com.geovanejunior.cursomc.repositories.ProdutoRepository;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPorId(Long id) {

        Optional<Pedido> obj = pedidoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
