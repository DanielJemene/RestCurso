package br.com.erudio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.erudio.data.vo.PersonVO;


import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	

	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable(value="id") Long id){
		return service.findById(id);
	}
	
	@GetMapping
	public List<PersonVO> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO PersonVO) {
		return service.create(PersonVO);
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO PersonVO) {
		return service.update(PersonVO);
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value="id") Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

	
	
	

}
