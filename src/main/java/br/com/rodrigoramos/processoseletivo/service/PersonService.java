package br.com.rodrigoramos.processoseletivo.service;

import br.com.rodrigoramos.processoseletivo.dto.PersonDTO;
import br.com.rodrigoramos.processoseletivo.model.Person;
import br.com.rodrigoramos.processoseletivo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }


    public Person convertDtoToModel(PersonDTO objDto) {
        return new Person(objDto.getId(), objDto.getNome(), objDto.getProfissao(), objDto.getLocalizacao(), objDto.getNivel());
    }
}
