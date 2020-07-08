package com.claim;

public class Employee extends Person {
	
	private int employeeId;
	private String password;
	
	public Employee() {
		super();
	}
		
	//overloaded constructor used when reading from file
	public Employee(String firstName, String lastName, String email, long phoneNumber, int employeeId, String password) {
		super(firstName, lastName, email, phoneNumber);
		this.employeeId = employeeId;
		this.password = password;
	}
	
	//overloaded constructor used when adding new employee in the app
	public Employee(String firstName, String lastName, String email, long phoneNumber, String password) {
		super(firstName, lastName, email, phoneNumber);
		this.password = password;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Employee ID: " + this.employeeId +
				" First Name: " + this.firstName +
				" Last Name: " + this.lastName;
	}
	
	public String formatData() {
		return this.employeeId + 
				"@@" + this.firstName +
				"@@" + this.lastName +
				"@@" + this.phoneNumber +
				"@@" + this.email +
				"@@" + this.password;
	}
	
}
