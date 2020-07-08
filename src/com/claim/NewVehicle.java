package com.claim;

import java.net.URL;
import java.time.LocalDate;

public class NewVehicle extends Vehicle {
	
	public NewVehicle() {
		super();
	}
	
	public NewVehicle(long id, short year, String make, String model, double askingPrice, 
			LocalDate dateAddedToCurrInventory, String description, URL picURL) {
		super(id, year, make, model, askingPrice, dateAddedToCurrInventory, 
			description, picURL);
	}
	
	public String toStringForCustomer() {
		return "Year: " + this.year + " Make: " + this.make + " Model: " + this.model + " Price: " + this.askingPrice + " Description: " + this.description;
	}

}
