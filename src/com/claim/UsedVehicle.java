package com.claim;

import java.awt.image.BufferedImage;
import java.util.Date;

public class UsedVehicle extends Vehicle{
	
	private int miles;
	//based on Kelley Blue Book Vehicle Condition Standards
	private KbbCondition kbbCondition;
	
	//the super isn't necessary now b/c constructor is empty.. but if I add anything.. it will also be used here
	public UsedVehicle() {
		super();
	}
		
	public UsedVehicle(Long id, String make, String model, double askingPrice, 
			Date dateAddedToCurrInventory, String description, BufferedImage pic, 
			int miles, KbbCondition kbbCondition) {
		super(id, make, model, askingPrice, dateAddedToCurrInventory, 
			description, pic);
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
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toStringForCustomer() {
		return "Make: " + this.make + " Model: " + this.model + "Price: " + this.askingPrice + " Description: " + this.description
				+ "Mileage: " + this.miles + "Condition: " + this.kbbCondition;
	}
	
	 

}
