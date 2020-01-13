package br.com.rodrigoramos.processoseletivo.repository;

import br.com.rodrigoramos.processoseletivo.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
