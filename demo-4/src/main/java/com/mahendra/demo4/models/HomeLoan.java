package com.mahendra.demo4.models;


public class HomeLoan {
	private String accountNumber;
	private String customerName;
	private double disbursedAmount;
	private double rateOfInterest;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getDisbursedAmount() {
		return disbursedAmount;
	}
	public void setDisbursedAmount(double disbursedAmount) {
		this.disbursedAmount = disbursedAmount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public HomeLoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HomeLoan(String accountNumber, String customerName, double disbursedAmount, double rateOfInterest) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.disbursedAmount = disbursedAmount;
		this.rateOfInterest = rateOfInterest;
	}
	
	
}
