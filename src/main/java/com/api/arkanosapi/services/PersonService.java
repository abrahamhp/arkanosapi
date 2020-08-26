package com.api.arkanosapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.arkanosapi.model.Person;
import com.api.arkanosapi.repositories.PersonRepository;


@Service
public class PersonService {
	
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    public Person getPersonById(long id) {
        return personRepository.findById(id);
    }
    
    public int create(Person person) {
        return personRepository.insert(person);
    }

    public int saveOrUpdate(Person person) {
        return personRepository.update(person);
    }


}
