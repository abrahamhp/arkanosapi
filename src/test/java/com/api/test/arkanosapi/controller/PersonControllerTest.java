package com.api.test.arkanosapi.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.api.arkanosapi.controller.PersonController;
import com.api.arkanosapi.model.Person;
import com.api.arkanosapi.services.PersonService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
	 @Mock
	  private PersonService restClientService;

	  private PersonController controller;
	  
	  private List<Person> persons; 
	  
	  @Before
	  public void setup() throws Exception {

	    controller = new PersonController();
	    ReflectionTestUtils.setField(controller, "personService", restClientService);
	    
	    this.persons = new ArrayList<Person>();
	    this.persons.add(new Person());
	    	   	    
	    when(restClientService.create(Mockito.any(Person.class))).thenAnswer(invocation -> {
	        persons.add((Person) invocation.getArguments()[0]);
	        return invocation.getArguments()[0];
	      });
	    
	    when(restClientService.getAllPersons()).thenReturn(persons);
	    
	    doNothing().when(restClientService).saveOrUpdate(Mockito.any(Person.class));
	    	    
	  }
	  
	  @Test
	  public void testCreate() throws Exception {
	    assertEquals(this.persons.size(), 1);
	    Person person = new Person();
	    	person.setId(1);
	        person.setName("Gabriel");
	        person.setPassportNumber("AB36478");
	        person.setAge(35);
	        person.setProfesion("Ingeniero");
	        person.setEmail("gabriel@gmail.com");
	        person.setWeight(77.5);
	    
	    this.controller.createPerson(person);
	    assertEquals(this.persons.size(), 2);
	  }
	  
	  @Test
	  public void testGetAllPersons() throws Exception {
	    persons.add(new Person());
	    String result = this.controller.getAllPersons().toString();
	    Gson gson = new Gson();
	    Type type = new TypeToken<List<Person>>() {}.getType();
	    List<Person> json = gson.fromJson(result, type);
	    assertEquals(json.size(), 2);
	  }
	  
	  
	  @Test
	  public void testSavePerson() throws Exception {
		  Person person = new Person();
	    	person.setId(1);
	        person.setName("Gabriel");
	        person.setPassportNumber("AB36478");
	        person.setAge(35);
	        person.setProfesion("Ingeniero");
	        person.setEmail("gabriel@gmail.com");
	        person.setWeight(77.5);
	        
	    this.controller.savePerson(person);
	    
	    Person result = this.persons.get(0);
	    assertEquals(result.getId(), "id");
	    assertEquals(result.getName(), "Gabriel");
	    assertEquals(result.getPassportNumber(), "AB36478");
	    assertEquals(result.getAge(), 35);
	    assertEquals(result.getProfesion(), "Ingeniero");
	    assertEquals(result.getEmail(), "gabriel@gmail.com");
	    assertEquals(result.getWeight(), "77.5");
	  }

}
