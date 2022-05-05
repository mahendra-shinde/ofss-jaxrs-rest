package com.mahendra.demo3;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

//Capture all "RuntimException" exceptions from all REST endpoints
//Please note: you need another exception handler for other exceptions
public class LoanExceptionHandler implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException ex) {
		ex.printStackTrace();
		return Response.status(404, ex.getMessage()).build();
	}

}
