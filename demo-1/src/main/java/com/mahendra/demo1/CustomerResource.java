package com.mahendra.demo1;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/api/customer")
public class CustomerResource {
	List<Customer> customers = new LinkedList<>();
	
	public CustomerResource() {
		customers.add(new Customer(101,"Dharmendra","Deol","Mumbai"));
		customers.add(new Customer(102,"Sunny","Deol","Mumbai"));
	}
	
	/// GET http://localhost:4000/api/customers/
	/*
	 * @GET
	 * 
	 * @Produces("text/html") public String findAll() {
	 * System.out.println("Invoking findAll method "); StringBuilder br = new
	 * StringBuilder(); for(Customer cust: customers) {
	 * br.append(cust.getCustId()).append(", ")
	 * .append(cust.getLastName()).append(", ")
	 * .append(cust.getFirstName()).append(", ")
	 * .append(cust.getAddress()).append("<br/>"); } return br.toString(); }
	 */
	/*
	 * @GET
	 * 
	 * @Produces({"application/json","application/xml"}) public Response
	 * findAllJSON() { System.out.println("Invoking findAll method "); Customer[]
	 * custs = customers.toArray(new Customer[customers.size()]); return
	 * Response.ok(custs).header("Count", custs.length).build(); }
	 */
	
//	@GET
//	public Response findAllTypes(@QueryParam("type") String type) {
//		System.out.println("Invoking findAll method ");
//		Customer[] custs = customers.toArray(new Customer[customers.size()]);
//		Response response= null;
//		if(type.equalsIgnoreCase("json")) {
//			response = Response.ok(custs,"Application/json").header("Count", custs.length).build();
//		}
//		else  {
//			response = Response.ok(custs,"Application/xml").header("Count", custs.length).build();
//		}
//		return response;	
//	}
//	
	
	
	
	@GET
	@Produces("text/html")
	@Path("/{custid}") // Place-holder, Auto conversion from String to INT
	public Response findById(@PathParam("custid") int custId) {
		for(Customer customer : customers) {
			if(customer.getCustId() == custId) {
				String response = "Id: "+custId+", Name: "+customer.getFirstName()+" "+customer.getLastName()+", Address: "+customer.getAddress()+"<br/>";
				return Response.ok(response).build();
			}
		}
		return Response.status(404 ,"No record found").entity("No customer found for id "+custId).build();
	}
	
	@GET
	@Produces({"application/json","application/xml"})
	@Path("/{custid}") // Place-holder, Auto conversion from String to INT
	public Customer findCustomerById(@PathParam("custid") int custId) {
		for(Customer customer : customers) {
			if(customer.getCustId() == custId) {
				return customer;
			}
		}
		return null;
	}
}
