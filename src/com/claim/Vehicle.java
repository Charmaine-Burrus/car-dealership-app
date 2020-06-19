package com.claim;

import java.awt.image.BufferedImage;
import java.lang.Math; 
import java.util.Date;

public abstract class Vehicle {
	
	protected long id;
	protected String make;
	protected String model;
	protected double price;
	protected Date dateAddedToCurrInventory;
	protected Date dateOfPurchase;
	protected String description;
	//picture - will have to be an internet link ... or figure out file
	protected BufferedImage pic;
	
	//default constructor
	public Vehicle() {
	}
	
	//overloaded constructor
	public Vehicle(long id, String make, String model, double price, 
			Date dateAddedToCurrInventory, Date dateOfPurchase, 
			String description, BufferedImage pic) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.price = price;
		this.dateAddedToCurrInventory = dateAddedToCurrInventory;
		this.dateOfPurchase = dateOfPurchase;
		this.description = description;
		this.pic = pic;
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
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
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

	//will be used to display all necc details to user
	public abstract String toString();
	
	public abstract String formatData();
	
	public boolean equals(Vehicle vehicle2) {
		if (this.id == vehicle2.getId()) {
			return true;
		}
		return false;
	}
	
	//.compareTo will be by id
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
