package com.api.arkanosapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.arkanosapi.model.Person;
import com.api.arkanosapi.services.PersonService;
import org.apache.log4j.Logger;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
	
    @Autowired
    private PersonService personService;
    private static Logger objLog = Logger.getLogger(PersonController.class);

    @GetMapping(value= "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value="/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE) 
    @ResponseStatus(code = HttpStatus.OK)
    public Person getPerson(@PathVariable("id") long id) {
        return personService.getPersonById(id);
    }

   
    @PostMapping(value= "/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public int createPerson(@RequestBody Person person) {
        personService.create(person);
        return (int)person.getId();
    }

    @PostMapping(value= "/save")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public int savePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
        return (int)person.getId();
    } 

}
