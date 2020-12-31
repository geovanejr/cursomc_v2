package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.domain.Estado;
import br.com.geovanejunior.cursomc.repositories.EstadoRepository;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAllEstado() {
        return estadoRepository.findAllByOrderByNome();
    }

    public Estado findById(Long estadoId) {

        Optional<Estado> obj = estadoRepository.findById(estadoId);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + estadoId + ", Tipo: " + Estado.class.getName()));
    }
}
