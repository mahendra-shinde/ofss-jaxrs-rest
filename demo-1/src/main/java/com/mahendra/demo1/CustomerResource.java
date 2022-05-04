package com.mahendra.demo1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/api/xyz")
public class CustomerResource {
	List<Customer> customers = new LinkedList<>();
	
	public CustomerResource() {
		customers.add(new Customer(101,"Dharmendra","Deol","Mumbai"));
		customers.add(new Customer(102,"Sunny","Deol","Mumbai"));
	}
	
	/// GET http://localhost:4000/api/customers/
	@GET
	@Produces("text/html")
	public String findAll() {
		System.out.println("Invoking findAll method ");
		StringBuilder br = new StringBuilder();
		for(Customer cust: customers) {
			br.append(cust.getCustId()).append(", ")
			.append(cust.getLastName()).append(", ")
			.append(cust.getFirstName()).append(", ")
			.append(cust.getAddress()).append("<br/>");
		}
		return br.toString();
	}
	
	@GET
	@Produces({"application/json","application/xml"})
	public Customer[] findAllJSON() {
		System.out.println("Invoking findAll method ");
		return customers.toArray(new Customer[customers.size()]);
	}
	
	
	@GET
	@Produces("text/html")
	@Path("/{custid}") // Place-holder, Auto conversion from String to INT
	public String findById(@PathParam("custid") int custId) {
		for(Customer customer : customers) {
			if(customer.getCustId() == custId) {
				String response = "Id: "+custId+", Name: "+customer.getFirstName()+" "+customer.getLastName()+", Address: "+customer.getAddress()+"<br/>";
				return response;
			}
		}
		return "<h3 style='color:red'>No record found</h3>";
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
