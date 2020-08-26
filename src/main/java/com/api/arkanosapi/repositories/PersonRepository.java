package com.api.arkanosapi.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.arkanosapi.model.Person;

@Repository
public class PersonRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonRowMapper implements RowMapper<Person> {
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getLong("id"));
			person.setName(rs.getString("name"));
			person.setPassportNumber(rs.getString("passport_number"));
			person.setAge(rs.getInt("age"));
			person.setProfesion(rs.getString("profesion"));
			person.setEmail(rs.getString("email"));
			person.setWeight(rs.getDouble("weight"));
			return person;
		}

	}

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(long id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, passport_number, age, profesion, email, weight) " 
				+ "values(?,  ?, ?, ?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getPassportNumber(), person.getAge(), person.getProfesion(), person.getEmail(), person.getWeight() });
	}

	public int update(Person person) {
		return jdbcTemplate.update("update person " + " set name = ?, passport_number = ?, age = ?, profesion = ?, email = ?, weight = ? " 
				+ " where id = ?",
				new Object[] { person.getName(), person.getPassportNumber(), person.getAge(), person.getProfesion(), person.getEmail(), person.getWeight(), person.getId() });
	}
}
