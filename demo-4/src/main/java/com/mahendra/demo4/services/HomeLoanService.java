package com.mahendra.demo4.services;

import java.util.*;

import com.mahendra.demo4.models.HomeLoan;

public class HomeLoanService {

	private List<HomeLoan> loans = new LinkedList<>();
	
	private HomeLoanService() {
		loans.add(new HomeLoan("0019611088","Rajiv Bhatia",24500000, 8.4));
		loans.add(new HomeLoan("0019612822","Mukesh Ambani",67100000, 9.5));
		loans.add(new HomeLoan("0019611654","Raj Kundra",21000000, 7.9));
	}
	
	public void save(HomeLoan loan) {
		if(loanExists(loan.getAccountNumber())) {
			throw new RuntimeException("Loan already exists");
		}
		loans.add(loan);
	}
	
	public HomeLoan findByAccNum(String accNum) {
		if(loanExists(accNum)) {
			for(HomeLoan loan: loans) {
				if(loan.getAccountNumber().equalsIgnoreCase(accNum)) {
					return loan;
				}
			}
		}
		throw new RuntimeException("Loan does not exists");
	}
	
	public void delete(String loanAcc) {
		HomeLoan loan = findByAccNum(loanAcc);
		loans.remove(loan);
	}
	
	//// FOR PUT
	public void update(HomeLoan loan) {
		HomeLoan loanRef = findByAccNum(loan.getAccountNumber());
		// replace the old values with new
		loanRef.setCustomerName(loan.getCustomerName());
		loanRef.setDisbursedAmount(loan.getDisbursedAmount());
		loanRef.setRateOfInterest(loan.getRateOfInterest());
	}
	
	/// FOR Patch
	public void updateInterest(String accNo, double newRate) {
		HomeLoan loanRef = findByAccNum(accNo);
		loanRef.setRateOfInterest(newRate);
	}
	
	
	private boolean loanExists(String accNum) {
		for(HomeLoan loan : loans) {
			if(loan.getAccountNumber().equalsIgnoreCase(accNum)) {
				return true;
			}
		}
		return false;
	}
	
	
	public List<HomeLoan> getAll(){
		return Collections.unmodifiableList(loans);
	}
	
	/// Singleton Implemetation
	private static HomeLoanService service = new HomeLoanService();
	
	public static HomeLoanService getInstance() {
		return service;
	}
}
