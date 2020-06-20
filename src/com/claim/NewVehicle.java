package com.claim;

import java.awt.image.BufferedImage;
import java.util.Date;

public class NewVehicle extends Vehicle {
	
	//the super isn't necessary now b/c constructor is empty.. but if I add anything.. it will also be used here
	public NewVehicle() {
		super();
	}
	
	public NewVehicle(Long id, String make, String model, double askingPrice, 
			Date dateAddedToCurrInventory, String description, BufferedImage pic) {
		super(id, make, model, askingPrice, dateAddedToCurrInventory, 
			description, pic);
	}
	
	//TO DO LATER: MIGHT NOT USE THIS IF I DISPLAY IT ALL IN A TABLE OR SOMETHING INSTEAD
	public String toStringForCustomer() {
		return "Make: " + this.make + " Model: " + this.model + "Price: " + this.askingPrice + " Description: " + this.description;
	}

}
