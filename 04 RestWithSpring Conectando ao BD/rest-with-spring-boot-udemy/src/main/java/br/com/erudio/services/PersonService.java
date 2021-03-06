package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.RecursoNaoEncontrado;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	
	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()-> new RecursoNaoEncontrado("Nenhum registro encontrado para esse id"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(()-> new RecursoNaoEncontrado("Nenhum registro encontrado para esse id"));
		
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(person);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(()-> new RecursoNaoEncontrado("Nenhum registro encontrado para esse id"));
		repository.delete(entity);
	}
	
	
}
