package com.cisco.skyfall;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cisco.skyfall.exception.KeywordNotFoundException;
import com.cisco.skyfall.response.ErrorDetail;

@RequestMapping(value="/api", produces = { "application/json", "application/xml" })
public abstract class BaseController {
	
	@ExceptionHandler(KeywordNotFoundException.class)
	public ErrorDetail myError(HttpServletRequest request, Exception exception) {
	    ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.BAD_REQUEST.value());
	    error.setMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().append("/error/111").toString());
	    return error;
	}
	
}