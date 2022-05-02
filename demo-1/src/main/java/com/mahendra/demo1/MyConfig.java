package com.mahendra.demo1;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyConfig extends ResourceConfig{

	public MyConfig() {
		register(CustomerResource.class);
		
	}
}
