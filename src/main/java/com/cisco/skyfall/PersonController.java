package com.cisco.skyfall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.skyfall.component.IPersonService;
import com.cisco.skyfall.exception.KeywordNotFoundException;

@RestController
public class PersonController extends BaseController {

	@Autowired
	private IPersonService personService;

	@RequestMapping(value = "/person/{id}")
	public ResponseEntity<?> info(@PathVariable Integer id) {
		Person p = personService.getPersonDetail(id);
		ResponseEntity<?> response = new ResponseEntity<>(p, HttpStatus.OK); 
		return response;
	}
	
	
	@RequestMapping(value = "/person")
	public ResponseEntity<?> getPersonDetail(@RequestParam(value="key") Integer key) {
		Person p = personService.getPersonDetail(key);
		ResponseEntity<?> response = new ResponseEntity<>(p, HttpStatus.OK); 
		throw new KeywordNotFoundException(key.toString());
	}
	
	
	
}