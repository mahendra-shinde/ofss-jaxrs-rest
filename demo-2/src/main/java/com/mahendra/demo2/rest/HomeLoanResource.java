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
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			return Response.status(400, ex.getMessage()).build();
		}
	}

	@DELETE
	@Path("/{accno}")
	public Response deletByAccNum(@PathParam("accno") String accNum) {
		try {
			service.delete(accNum);
			return Response.ok("Record deleted ").build();
		} catch (RuntimeException ex) {
			return Response.status(404, ex.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes("application/json")
	public Response update(HomeLoan loan) {
		try {
		service.update(loan);
		return Response.ok("Updated !").build();
		}catch(RuntimeException ex) {
			return Response.status(404,ex.getMessage()).build();
		}
	}
	
	@PATCH
	public Response updateInterest(@QueryParam("accno")String accNo, @QueryParam("newrate")double rate) {
		try {
		service.updateInterest(accNo, rate);
		return Response.ok("Updated rate of interest").build();
		}catch(RuntimeException ex) {
			return Response.status(404,ex.getMessage()).build();
		}
	}
}
