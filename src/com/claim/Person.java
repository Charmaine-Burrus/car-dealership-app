package com.claim;

public abstract class Person {
	
	protected String firstName;
	protected String lastName;
	protected String email;
	protected long phoneNumber;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, String email, long phoneNumber) {
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
		Person otherPerson = (Person) obj;
        return this.phoneNumber == otherPerson.getPhoneNumber();
	}
	
	@Override
    public int hashCode() {
        return Long.hashCode(this.phoneNumber);
    }

	public int compareTo(Person otherPerson) {
		return this.lastName.compareTo(otherPerson.getLastName());
	}
	
	public abstract String toString();
	
	public abstract String formatData();

}
