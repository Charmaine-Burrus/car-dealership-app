package com.claim;

import java.net.URL;
import java.time.LocalDate;

public class NewVehicle extends Vehicle {
	
	//the super isn't necessary now b/c constructor is empty.. but if I add anything.. it will also be used here
	public NewVehicle() {
		super();
	}
	
	public NewVehicle(Long id, String make, String model, double askingPrice, 
			LocalDate dateAddedToCurrInventory, String description, URL picURL) {
		super(id, make, model, askingPrice, dateAddedToCurrInventory, 
			description, picURL);
	}
	
	//TO DO LATER: MIGHT NOT USE THIS IF I DISPLAY IT ALL IN A TABLE OR SOMETHING INSTEAD
	public String toStringForCustomer() {
		return "Make: " + this.make + " Model: " + this.model + "Price: " + this.askingPrice + " Description: " + this.description;
	}

}
