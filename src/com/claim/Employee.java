package com.claim;

public class Employee extends Person {
	
	private int employeeId;
	
	//default constructor
	public Employee() {
		super();
	}
		
	//overloaded constructor used when reading from file
	public Employee(String firstName, String lastName, String email, long phoneNumber, int employeeId) {
		super(firstName, lastName, email, phoneNumber);
		this.employeeId = employeeId;
	}
	
	//overloaded constructor used when adding new employee in the app
	public Employee(String firstName, String lastName, String email, long phoneNumber) {
		super(firstName, lastName, email, phoneNumber);
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
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
