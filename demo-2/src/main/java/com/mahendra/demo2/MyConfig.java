package com.mahendra.demo2;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.mahendra.demo2.rest.HomeLoanResource;

@ApplicationPath("/")
public class MyConfig extends ResourceConfig{

	public MyConfig() {
		register(HomeLoanResource.class);
	}
}
