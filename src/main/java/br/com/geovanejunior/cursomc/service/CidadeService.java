package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Cidade;
import br.com.geovanejunior.cursomc.domain.Estado;
import br.com.geovanejunior.cursomc.repositories.CidadeRepository;
import br.com.geovanejunior.cursomc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findByEstado(Long estadoId) {

        return cidadeRepository.findCidades(estadoId);
    }

}
