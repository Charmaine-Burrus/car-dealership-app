package com.claim;

public class Dealership {
	
	private String name;
	private NewVehicle[] newInventory;
	private UsedVehicle[] usedInventory;
	private Vehicle[] over120DaysInventory;
	private Vehicle[] soldInventory;
	private int latestID;
	
	public Dealership() {
	}
	
	public Dealership(String name, NewVehicle[] newInventory, UsedVehicle[] usedInventory,
			Vehicle[] over120DaysInventory, Vehicle[] soldInventory, int latestID) {
		this.name = name;
		this.newInventory = newInventory; 
		this.usedInventory = usedInventory;
		this.over120DaysInventory = over120DaysInventory;
		this.soldInventory = soldInventory;
		this.latestID = latestID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public NewVehicle[] getNewInventory() {
		return newInventory;
	}
	public void setNewInventory(NewVehicle[] newInventory) {
		this.newInventory = newInventory;
	}
	public UsedVehicle[] getUsedInventory() {
		return usedInventory;
	}
	public void setUsedInventory(UsedVehicle[] usedInventory) {
		this.usedInventory = usedInventory;
	}
	public Vehicle[] getOver120DaysInventory() {
		return over120DaysInventory;
	}
	public void setOver120DaysInventory(Vehicle[] over120DaysInventory) {
		this.over120DaysInventory = over120DaysInventory;
	}
	public Vehicle[] getSoldInventory() {
		return soldInventory;
	}
	public void setSoldInventory(Vehicle[] soldInventory) {
		this.soldInventory = soldInventory;
	}
	public int getLatestID() {
		return latestID;
	}
	public void setLatestID(int latestID) {
		this.latestID = latestID;
	}
	
	public void moveCarsToBid() {
		//loop through usedInventory
		//loop through usedInventory
		//if currentDate - dateEntere > 120 {   //TO DO: How do I get current date?
		//add to over120Days
		//remove from previous inventory
		//change eligbileForBid to true
	}
	}

	public void addToInventory(//all details for vehicle?) {
		//LOOK BACK AT HOW I DID LIBRARY AND PHONEBOOK
		//make a Vehicle with these details
		//set id & everthing else
		//update most recent id
		//if the vehicle is a newVehicle add to newInventory  //TO DO: How do I do this?
		//if the vehicle is a usedVehicle add to used
		//set dateAddedToInventory to today
	}
	
	public void sellVehicle() {
		//update daysold
		//update buyer
		//update price sold
		//transfer from one inventory to the other
	} 

}
