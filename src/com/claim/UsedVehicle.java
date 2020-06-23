package com.claim;

import java.net.URL;
import java.time.LocalDate;

public class UsedVehicle extends Vehicle{
	
	private int miles;
	//based on Kelley Blue Book Vehicle Condition Standards
	private KbbCondition kbbCondition;
	
	//the super isn't necessary now b/c constructor is empty.. but if I add anything.. it will also be used here
	public UsedVehicle() {
		super();
	}
		
	public UsedVehicle(Long id, String make, String model, double askingPrice, 
			LocalDate dateAddedToCurrInventory, String description, URL picURL, 
			int miles, KbbCondition kbbCondition) {
		super(id, make, model, askingPrice, dateAddedToCurrInventory, 
			description, picURL);
		this.miles = miles;
		this.kbbCondition = kbbCondition;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public KbbCondition getKbbCondition() {
		return kbbCondition;
	}

	public void setKbbCondition(KbbCondition kbbCondition) {
		this.kbbCondition = kbbCondition;
	}
	
	@Override
	public String toStringForCustomer() {
		return "Make: " + this.make + " Model: " + this.model + "Price: " + this.askingPrice + " Description: " + this.description
				+ "Mileage: " + this.miles + "Condition: " + this.kbbCondition;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		result += "Mileage: " + this.miles;
		result += "KBB Condition: " + this.kbbCondition;
		return result;
	}
	
	@Override
	public String formatData() {
		String result = super.formatData();
		result += "|" + this.miles;
		result += "|" + this.kbbCondition;
		return result;
	}
	
	 

}
