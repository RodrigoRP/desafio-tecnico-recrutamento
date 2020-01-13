package br.com.rodrigoramos.processoseletivo.repository;

import br.com.rodrigoramos.processoseletivo.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
