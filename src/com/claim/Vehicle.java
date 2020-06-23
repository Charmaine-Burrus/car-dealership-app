package com.claim;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import javax.imageio.ImageIO;

public abstract class Vehicle {
	
	protected long id;
	protected String make;
	protected String model;
	protected double askingPrice;
	protected LocalDate dateAddedToCurrInventory;
	protected String description;
	//picture - will have to be an internet link ... or figure out file
	protected URL picURL;

	protected boolean eligibleForBid;
	
	protected BufferedImage pic;
	
	protected double priceSold;
	protected Buyer buyer;
	protected LocalDate dateOfPurchase;
	
	//default constructor
	public Vehicle() {
	}
	
	//overloaded constructor
	public Vehicle(long id, String make, String model, double askingPrice, 
			LocalDate dateAddedToCurrInventory, String description, URL picURL) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.askingPrice = askingPrice;
		this.dateAddedToCurrInventory = dateAddedToCurrInventory;
		this.description = description;
		this.picURL = picURL;
		
		this.eligibleForBid = false;
		try {
			this.pic = ImageIO.read(picURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void setDateAddedToCurrInventory(LocalDate dateAdded) {
		this.dateAddedToCurrInventory = dateAdded;
	}
	
	public LocalDate getDateAddedToCurrInventory() {
		return this.dateAddedToCurrInventory;
	}
	
	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	
	public LocalDate getDateOfPurchase() {
		return this.dateOfPurchase;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public URL getPicURL() {
		return picURL;
	}

	public void setPicURL(URL picURL) {
		this.picURL = picURL;
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
				"Description" + this.description + "Pic URL:" + this.picURL + "," +
				"Eligible for Bid:" + this.eligibleForBid;
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
		String result = this.id + "|" + this.make + "|" + 
			this.model + "|" + this.askingPrice + "|" +
			this.dateAddedToCurrInventory + "|" + 
			this.description + "|" + this.picURL + "|" +
			this.eligibleForBid;
		//TO DO LATER: SHOULD THIS BE INCLUDED IF NULL OR NOT... FOR READING IN FROM PDF? PRBLY NOT
		if (this.priceSold != 0) {
			result += ("|" + this.priceSold);
		}
		if (this.buyer != null) {
			result += "|" + this.buyer.formatData();
		}
		if (this.dateOfPurchase != null) {
			result += "|" + this.dateOfPurchase;
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
