package com.mahendra.demo3;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.mahendra.demo3.rest.HomeLoanResource;

@ApplicationPath("/")
public class MyConfig extends ResourceConfig{

	public MyConfig() {
		register(HomeLoanResource.class);
		register(LoanExceptionHandler.class);
	}
}
