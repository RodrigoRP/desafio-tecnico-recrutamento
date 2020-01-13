package br.com.rodrigoramos.processoseletivo.repository;

import br.com.rodrigoramos.processoseletivo.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    List<Candidatura> findAllByVagaId(Long idVaga);
}
