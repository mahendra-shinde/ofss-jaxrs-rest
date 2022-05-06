package com.mahendra.demo4;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	@Context /// Security Context 
	private ResourceInfo info;
	
	private static final String AUTHORIZATION_PROPERTY="Authorization";
	private static final String AUTHORIZATION_SCHEME="Basic";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//Get the details of Target REST endpoint
		Method method = info.getResourceMethod();
		System.out.println("FILTER:  Detected request made for "+method.getName());
		
		final MultivaluedMap<String, String> header = requestContext.getHeaders();
		final List<String> auth = header.get(AUTHORIZATION_PROPERTY);
		
		// Either Authorization is NOT defined or is Empty
		if(auth == null || auth.isEmpty()) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Please login/authenticate before you proceed").build());
			return ;
		}
		final String encodedUserAndPass = auth.get(0).replaceFirst(AUTHORIZATION_SCHEME + " ", "");
		System.out.println("User credentials found: "+encodedUserAndPass);
		
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedUserAndPass.getBytes()));
		System.out.println("User credentials DECODED: "+decodedCredentials);
		String[] credentials = decodedCredentials.split(":");
		
		if(! authenticateUser(credentials[0], credentials[1])) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Invalid User credentials").build());
			return;
		}
	}
	
	private boolean authenticateUser(String username, String password) {
		if(username.equalsIgnoreCase("mahendra") && password.equals("Haha-HiHi")) {
			return true;
		}
		return false;
	}

}
