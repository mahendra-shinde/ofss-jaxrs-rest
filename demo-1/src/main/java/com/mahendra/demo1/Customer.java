package com.mahendra.demo1;

// POJO / Plain Old Java Object
// 1. Class must be PUBLIC and in "TitleCase"
// 2. All attributes must be PRIVATE and have Getters and Setters
// 3. Members (excluding STATIC) name must be in "camelCase"
// 4. A Public NO-ARG constructor
public class Customer {

	private int custId;
	
	private String firstName;
	private String lastName;
	private String address;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//No-Arg constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, String firstName, String lastName, String address) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	
}
