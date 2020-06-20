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
	

}
