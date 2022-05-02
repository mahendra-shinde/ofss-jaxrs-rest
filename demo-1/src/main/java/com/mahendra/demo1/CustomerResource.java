package com.mahendra.demo1;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/customer")
public class CustomerResource {
	List<Customer> customers = new LinkedList<>();
	
	public CustomerResource() {
		customers.add(new Customer(101,"Dharmendra","Deol","Mumbai"));
		customers.add(new Customer(102,"Sunny","Deol","Mumbai"));
	}
	
	/// GET http://localhost:4000/api/customers/
	@GET
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
}
