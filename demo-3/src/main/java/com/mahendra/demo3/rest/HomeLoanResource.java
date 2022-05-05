package com.mahendra.demo3.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.mahendra.demo3.models.HomeLoan;
import com.mahendra.demo3.services.HomeLoanService;

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
		service.save(loan);
		return Response.ok("New loan created").build();
	}

	@DELETE
	@Path("/{accno}")
	public Response deletByAccNum(@PathParam("accno") String accNum) {
		service.delete(accNum);
		return Response.ok("Record deleted ").build();
	}

	@PUT
	@Consumes("application/json")
	public Response update(HomeLoan loan) {
		service.update(loan);
		return Response.ok("Updated !").build();
	}

	@PATCH
	public Response updateInterest(@QueryParam("accno") String accNo, @QueryParam("newrate") double rate) {
		service.updateInterest(accNo, rate);
		return Response.ok("Updated rate of interest").build();
	}
}
