package com.cisco.skyfall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.skyfall.component.IPersonService;

@RestController
@RequestMapping(value = "/", produces = { "application/json", "application/xml" })
public class PersonController {
	
	@Autowired
	private IPersonService personService;

	@RequestMapping(value = "/person/{id}")
	public Person getPersonDetail(@PathVariable Integer id) {
		Person p = personService.getPersonDetail(id);
		return p;
	}
}