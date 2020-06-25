package com.claim;

public class Buyer {
	
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	
	//default constructor
	public Buyer() {
	}
		
	//overloaded constructor
	public Buyer(String firstName, String lastName, String email, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean equals(Buyer otherBuyer) {
		if (this.email.equals(otherBuyer.getEmail())) {
			return true;
		}
		return false;
	}
	
	//.compareTo will be alphabetical by last name
	public int compareTo(Buyer otherBuyer) {
		return this.lastName.compareTo(otherBuyer.getLastName());
	}
	
	public String toString() {
		return "First Name: " + this.firstName +
				"Last Name: " + this.lastName +
				"Email Address: " + this.email +
				"Phone Number: " + this.phoneNumber;
	}
	
	public String formatData() {
		return this.firstName +
				";" + this.lastName +
				";" + this.email +
				";" + this.phoneNumber;
	}

}
