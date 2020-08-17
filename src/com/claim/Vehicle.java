package com.claim;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Vehicle {
	
	protected long id;
	protected short year;
	protected String make;
	protected String model;
	protected double askingPrice;
	protected LocalDate dateAddedToCurrInventory;
	protected String description;
	protected URL picURL;
	
	protected double priceSold;
	protected Buyer buyer;
	protected LocalDate dateOfPurchase;
	
	public Vehicle() {
	}
	
	public Vehicle(long id, short year, String make, String model, double askingPrice, 
			LocalDate dateAddedToCurrInventory, String description, URL picURL) {
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
		this.askingPrice = askingPrice;
		this.dateAddedToCurrInventory = dateAddedToCurrInventory;
		this.description = description;
		this.picURL = picURL;
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
	
	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	//can be used to display all details to admin - NewVehicle will use this & Used Vehicle will override it
	@Override
	public String toString() {
		String result = "ID: " + this.id + " Year: " + this.year + " Make: " + this.make + 
				" Model: " + this.model + " Asking Price: " + this.askingPrice + 
				" Date Added to Current Inventory: " +	this.dateAddedToCurrInventory + 
				" Description: " + this.description + " Pic URL: " + this.picURL + ",";
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
	
	//can be used to display all necc details to user
	public abstract String toStringForCustomer();
	
	//NewVehicle will use this & Used Vehicle will override it
	public String formatData() {
		String result = this.id + "," + this.year + "," + this.make + "," + 
			this.model + "," + this.askingPrice + "," +
			this.dateAddedToCurrInventory + "," + 
			this.description + "," + this.picURL;
		if (this.priceSold != 0) {
			result += ("," + this.priceSold);
		}
		if (this.buyer != null) {
			result += "," + this.buyer.formatData();
		}
		if (this.dateOfPurchase != null) {
			result += "," + this.dateOfPurchase;
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
		Vehicle otherVehicle = (Vehicle) obj;
        return this.id == otherVehicle.getId();
	}
	
	@Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }
	
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
	
	public boolean isEligibleForBid() {
		LocalDate today = LocalDate.now();
		long daysInInventory = ChronoUnit.DAYS.between(this.dateAddedToCurrInventory, today);
		if (daysInInventory >= 120) {
			return true;
		}
		return false;
	}

}
