package com.claim;

public class Employee extends Person {
	
	private long employeeId;
	
	//default constructor
	public Employee() {
		super();
	}
		
	//overloaded constructor
	public Employee(String firstName, String lastName, String email, long phoneNumber, long employeeId) {
		super(firstName, lastName, email, phoneNumber);
		this.employeeId = employeeId;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	public String toString() {
		return "Employee ID: " + this.employeeId +
				"First Name: " + this.firstName +
				"Last Name: " + this.lastName;
	}
	
	//To do: add possible employee to sale??
	public String formatData() {
		return this.employeeId + 
				"@@" + this.firstName +
				"@@" + this.lastName +
				"@@" + this.email +
				"@@" + this.phoneNumber;
	}
	
}
