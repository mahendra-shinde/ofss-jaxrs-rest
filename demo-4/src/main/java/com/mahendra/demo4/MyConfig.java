package com.mahendra.demo4;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.mahendra.demo4.rest.HomeLoanResource;

@ApplicationPath("/")
public class MyConfig extends ResourceConfig{

	public MyConfig() {
		register(HomeLoanResource.class);
		register(LoanExceptionHandler.class);
		register(AuthenticationFilter.class);
	}
}
