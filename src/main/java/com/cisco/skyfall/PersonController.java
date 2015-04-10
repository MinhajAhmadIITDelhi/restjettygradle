package com.cisco.skyfall;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.skyfall.component.IPersonService;
import com.cisco.skyfall.exception.KeywordNotFoundException;
import com.cisco.skyfall.response.ErrorDetail;

@RestController
@RequestMapping(value = "/ou", produces = { "application/json", "application/xml" })
public class PersonController {

	@Autowired
	private IPersonService personService;

	@RequestMapping(value = "/person/{id}")
	public ResponseEntity<Person> getPersonDetail(@PathVariable Integer id) {
		Person p = personService.getPersonDetail(id);
		ResponseEntity<Person> response = new ResponseEntity<Person>(p, HttpStatus.OK); 
		return response;
	}
	
	
	@RequestMapping("/info")
    public String info(@RequestParam(value="key") String key, Model model) {
    if (!"key101".equals(key)) {
	throw new KeywordNotFoundException(key);
    }
        return "success";
   }
	
	@ExceptionHandler(KeywordNotFoundException.class)
	public ErrorDetail myError(HttpServletRequest request, Exception exception) {
	    ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.BAD_REQUEST.value());
	    error.setMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().append("/error/111").toString());
	    return error;
	}
	
}