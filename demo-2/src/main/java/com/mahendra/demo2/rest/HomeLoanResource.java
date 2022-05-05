package com.mahendra.demo2.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.mahendra.demo2.models.HomeLoan;
import com.mahendra.demo2.services.HomeLoanService;

@Path("/api/homeloan")
public class HomeLoanResource {
	
	private HomeLoanService service;
	
	public HomeLoanResource() {
		service = HomeLoanService.getInstance();
	}
	
	@GET
	@Produces("application/json")
	public HomeLoan[] getAll() {
		List<HomeLoan> loans = service.getAll();
		return loans.toArray(new HomeLoan[loans.size()]);
	}
	
	
	@POST
	@Consumes("application/json")
	public Response create(HomeLoan loan) {
		try {
		service.save(loan);
		return Response.ok("New loan created").build();
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			return Response.status(400, ex.getMessage()).build();
		}
	}
}
