package br.com.rodrigoramos.processoseletivo.repository;

import br.com.rodrigoramos.processoseletivo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
