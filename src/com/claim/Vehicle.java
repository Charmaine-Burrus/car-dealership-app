package com.claim;

import java.awt.image.BufferedImage;
import java.util.Date;

public abstract class Vehicle {
	
	protected long id;
	protected String make;
	protected String model;
	protected double askingPrice;
	protected Date dateAddedToCurrInventory;
	protected String description;
	//picture - will have to be an internet link ... or figure out file
	protected BufferedImage pic;
	protected boolean eligibleForBid;
	
	protected double priceSold;
	protected Buyer buyer;
	protected Date dateOfPurchase;
	
	//default constructor
	public Vehicle() {
	}
	
	//overloaded constructor
	public Vehicle(long id, String make, String model, double askingPrice, 
			Date dateAddedToCurrInventory, String description, BufferedImage pic) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.askingPrice = askingPrice;
		this.dateAddedToCurrInventory = dateAddedToCurrInventory;
		this.description = description;
		this.pic = pic;
		this.eligibleForBid = false;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setaskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}
	
	public double getaskingPrice() {
		return this.askingPrice;
	}
	
	public void setDateAddedToCurrInventory(Date dateAdded) {
		this.dateAddedToCurrInventory = dateAdded;
	}
	
	public Date getDateAddedToCurrInventory() {
		return this.dateAddedToCurrInventory;
	}
	
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	
	public Date getDateOfPurchase() {
		return this.dateOfPurchase;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setPic(BufferedImage pic) {
		this.pic = pic;
	}
	
	public BufferedImage getPic() {
		return this.pic;
	}

	public double getPriceSold() {
		return priceSold;
	}

	public void setPriceSold(double priceSold) {
		this.priceSold = priceSold;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public boolean isEligibleForBid() {
		return eligibleForBid;
	}

	public void setEligibleForBid(boolean eligibleForBid) {
		this.eligibleForBid = eligibleForBid;
	}

	//will be used to display all details to admin - NewVehicle will use this & Used Vehicle will override it
	public String toString() {
		String result = "ID: " + this.id + "Make: " + this.make + 
				"Model: " + this.model + "Asking Price: " + this.askingPrice + 
				"Date Added to Current Inventory" +	this.dateAddedToCurrInventory + 
				"Description" + 
		this.description + "," + 
		this.pic + ",";
		if (this.priceSold != 0) {
			result += this.priceSold + ",";
		}
		if (this.buyer != null) {
			result += this.buyer + ",";
		}
		if (this.dateOfPurchase != null) {
			result += this.dateOfPurchase;
		}
		return result;
	}
	
	//will be used to display all necc details to user
	public abstract String toStringForCustomer();
	
	//NewVehicle will use this & Used Vehicle will override it
	public String formatData() {
		String result = this.id + "," + this.make + "," + 
			this.model + "," + this.askingPrice + "," +
			this.dateAddedToCurrInventory + "," + 
			this.description + "," + this.pic + ",";
		//TO DO LATER: SHOULD THIS BE INCLUDED IF NULL OR NOT... FOR READING IN FROM PDF? PRBLY NOT
		if (this.priceSold != 0) {
			result += this.priceSold + ",";
		}
		if (this.buyer != null) {
			result += this.buyer + ",";
		}
		if (this.dateOfPurchase != null) {
			result += this.dateOfPurchase;
		}
		return result;
	}
	
	public boolean equals(Vehicle vehicle2) {
		if (this.id == vehicle2.getId()) {
			return true;
		}
		return false;
	}
	
	//.compareTo by id
	public int compareTo(Vehicle vehicle2) {
		if (this.id == vehicle2.getId()) {
			return 0;
		}
		else {
			if (this.id < vehicle2.getId()) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}

}
