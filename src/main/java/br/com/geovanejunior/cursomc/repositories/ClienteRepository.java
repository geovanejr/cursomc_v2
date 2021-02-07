package br.com.geovanejunior.cursomc.repositories;

import br.com.geovanejunior.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Transactional
    Cliente findByEmail(String email);

    @Transactional
    Cliente findBycpfOUCNPJ(String cpfOUCNPJ);
}
