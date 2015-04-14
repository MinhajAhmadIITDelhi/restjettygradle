package com.cisco.skyfall;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/api", produces = { "application/json", "application/xml" })
public abstract class BaseController {
	
/*	@ExceptionHandler(KeywordNotFoundException.class)
	public ErrorDetail myError(HttpServletRequest request, Exception exception) {
	    ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.BAD_REQUEST.value());
	    error.setMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().append("/error/111").toString());
	    return error;
	}
*/	
}