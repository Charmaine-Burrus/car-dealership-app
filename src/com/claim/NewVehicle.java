package com.claim;

import java.awt.image.BufferedImage;
import java.util.Date;

public class NewVehicle extends Vehicle {
	
	//the super isn't necessary now b/c constructor is empty.. but if I add anything.. it will also be used here
	public NewVehicle() {
		super();
	}
	
	public NewVehicle(String make, String model, double price, 
			Date dateAddedToCurrInventory, Date dateOfPurchase, 
			String description, BufferedImage pic) {
		super(make, model, price, dateAddedToCurrInventory, 
			dateOfPurchase, description, pic);
	}
	
	//MIGHT NOT USE THIS IF I DISPLAY IT ALL IN A TABLE OR SOMETHING INSTEAD
	@Override
	public String toString() {
		return "Make: " + this.make + " Model: " + this.model + " Description: " + this.description;
	}

}
