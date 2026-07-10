package org.example.session6practice.data.services;

import org.example.session6practice.data.entities.Person;
import org.example.session6practice.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addOrUpdate(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public void deletePersonById(long id) {
        personRepository.deleteById(id);
    }

    public Person findPersonById(long id) {
        return personRepository.findById(id).get();
    }

    public List<Person> findByNameAndFamily(String name, String family,int perPage,int pageNo) {
        return personRepository.findPersonByNameAndFamily(name,family, PageRequest.of(pageNo,perPage)).stream().toList();
    }

}
