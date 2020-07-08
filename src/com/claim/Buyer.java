package com.claim;

public class Buyer extends Person {
	
	public Buyer() {
		super();
	}
		
	public Buyer(String firstName, String lastName, String email, long phoneNumber) {
		super(firstName, lastName, email, phoneNumber);
	}
	
	public String toString() {
		return "First Name: " + this.firstName +
				" Last Name: " + this.lastName +
				" Email Address: " + this.email +
				" Phone Number: " + this.phoneNumber;
	}
	
	public String formatData() {
		return this.firstName +
				";" + this.lastName +
				";" + this.email +
				";" + this.phoneNumber;
	}

}
