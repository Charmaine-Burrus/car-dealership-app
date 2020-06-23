package com.claim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Dealership {
	
	private String name;
	private ArrayList<NewVehicle> newInventory;
	private ArrayList<UsedVehicle> usedInventory;
	//private ArrayList<Vehicle> over120DaysInventory;
	private ArrayList<Vehicle> soldInventory;
	private int latestID;
	
	public Dealership() {
	}
	
	public Dealership(String name, ArrayList<NewVehicle> newInventory, ArrayList<UsedVehicle> usedInventory,
			 ArrayList<Vehicle> soldInventory, int latestID) { //ArrayList<Vehicle> over120DaysInventory,
		this.name = name;
		this.newInventory = newInventory; 
		this.usedInventory = usedInventory;
		//this.over120DaysInventory = over120DaysInventory;
		this.soldInventory = soldInventory;
		this.latestID = latestID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<NewVehicle> getNewInventory() {
		return newInventory;
	}
	public void setNewInventory(ArrayList<NewVehicle> newInventory) {
		this.newInventory = newInventory;
	}
	public ArrayList<UsedVehicle> getUsedInventory() {
		return usedInventory;
	}
	public void setUsedInventory(ArrayList<UsedVehicle> usedInventory) {
		this.usedInventory = usedInventory;
	}
//	public ArrayList<Vehicle> getOver120DaysInventory() {
//		return over120DaysInventory;
//	}
//	public void setOver120DaysInventory(ArrayList<Vehicle> over120DaysInventory) {
//		this.over120DaysInventory = over120DaysInventory;
//	}
	public ArrayList<Vehicle> getSoldInventory() {
		return soldInventory;
	}
	public void setSoldInventory(ArrayList<Vehicle> soldInventory) {
		this.soldInventory = soldInventory;
	}
	public int getLatestID() {
		return latestID;
	}
	public void setLatestID(int latestID) {
		this.latestID = latestID;
	}
	
	//to do: COULD PROBABLY MAKE ALL THE INVENTORIES HASHSETS INSTEAD IF JUST ADDING AND REMOVING AND PRINTING (sorted hashset)
	public void setCarsToBid() {
		LocalDate today = LocalDate.now();
		//loop through usedInventory
		for (UsedVehicle vehicle : this.usedInventory) {
			//if currentDate - dateAddedToInv >= 120
			Period period = Period.between(today, vehicle.dateAddedToCurrInventory);
			int daysInInventory = period.getDays();
			if (daysInInventory >= 120) {
//				//add to over120Days
//				this.over120DaysInventory.add(vehicle);
//				//remove from previous inventory
//				this.usedInventory.remove(vehicle);
				//change eligbileForBid to true
				vehicle.eligibleForBid = true;
			}
		}
		//loop through usedInventory
		for (NewVehicle vehicle : this.newInventory) {
			//if currentDate - dateAddedToInv >= 120
			Period period = Period.between(today, vehicle.dateAddedToCurrInventory);
			int daysInInventory = period.getDays();
			if (daysInInventory >= 120) {
//				//add to over120Days
//				this.over120DaysInventory.add(vehicle);
//				//remove from previous inventory
//				this.usedInventory.remove(vehicle);
				//change eligbileForBid to true
				vehicle.eligibleForBid = true;
			}
		}
	}

//	public void addToInventory(//all details for vehicle?) {
//		//LOOK BACK AT HOW I DID LIBRARY AND PHONEBOOK
//		//make a Vehicle with these details
//		//set id & everthing else
//		//update most recent id
//		//if the vehicle is a newVehicle add to newInventory  //TO DO: How do I do this?
//		//if the vehicle is a usedVehicle add to used
//		//set dateAddedToInventory to today
//	}
	
//	public void sellVehicle() {
//		//update daysold
//		//update buyer
//		//update price sold
//		//transfer from one inventory to the other
//	} 
	
	//to do: simplify this by doing something more similar to phonebook app
	public void saveAllInventoriesToFiles() {
		String path = "C:\\Users\\Charmaine\\Documents\\Dealership files\\";
		
		//for new vehicles
		String filePath = path + "newVehicles" + ".txt";
		//BW takes a FW argument
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			String inventoryString = "";
			//adds each Vehicle to the string using the Vehicle's formatData method
			for (Vehicle vehicle : this.newInventory) {
				inventoryString += (vehicle.formatData() + "\n");
			}
			bw.write(inventoryString);
			bw.close();  
		}catch (IOException e) {
			System.out.println("Error writing to file");
		}
		
		//for used vehicles
		filePath = path + "usedVehicles" + ".txt";
		//BW takes a FW argument
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			String inventoryString = "";
			//adds each Vehicle to the string using the Vehicle's formatData method
			for (Vehicle vehicle : this.usedInventory) {
				inventoryString += (vehicle.formatData() + "\n");
			}
			bw.write(inventoryString);
			bw.close();  
		}catch (IOException e) {
			System.out.println("Error writing to file");
		}
		
//		//for vehicles for bid
//		filePath = path + "vehiclesForBid" + ".txt";
//		//BW takes a FW argument
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//			String inventoryString = "";
//			//adds each Vehicle to the string using the Vehicle's formatData method
//			for (Vehicle vehicle : this.over120DaysInventory) {
//				inventoryString += (vehicle.formatData() + "\n");
//			}
//			bw.write(inventoryString);
//			bw.close();  
//		}catch (IOException e) {
//			System.out.println("Error writing to file");
//		}
		
		//for sold vehicles
				filePath = path + "soldVehicles" + ".txt";
				//BW takes a FW argument
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
					String inventoryString = "";
					//adds each Vehicle to the string using the Vehicle's formatData method
					for (Vehicle vehicle : this.soldInventory) {
						inventoryString += (vehicle.formatData() + "\n");
					}
					bw.write(inventoryString);
					bw.close();  
				}catch (IOException e) {
					System.out.println("Error writing to file");
				}
	}
	
	public void readInventoriesFromFile() {
		String path = "C:\\Users\\Charmaine\\Documents\\Dealership files\\";
		
		//for new vehicles
		String filePath = path + "newVehicles" + ".txt";
		try {
			//this scanner is taking in a new file
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNextLine()) {
				String vehicleInfo = scanner.nextLine();
				//above line will look like id, make, model, asking price, date added, description, picture???, maybe price sold, maybe buyer, maybe date of purchase
				//dates are formatted 2019-01-01
				Vehicle vehicle = createNewVehicleFromFile(vehicleInfo);
				this.newInventory.add((NewVehicle)vehicle);
				scanner.close();
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error reading from file");
		}
	
		//for used vehicles
		filePath = path + "usedVehicles" + ".txt";
		try {
			//this scanner is taking in a new file
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNextLine()) {
				String vehicleInfo = scanner.nextLine();
				Vehicle vehicle = createUsedVehicleFromFile(vehicleInfo);
				this.usedInventory.add((UsedVehicle)vehicle);
				scanner.close();
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error reading from file");
		}
		
		//for sold vehicles
				filePath = path + "soldVehicles" + ".txt";
				try {
					//this scanner is taking in a new file
					Scanner scanner = new Scanner(new File(filePath));
					while(scanner.hasNextLine()) {
						Vehicle vehicle;
						String vehicleInfo = scanner.nextLine();
						String[] items = vehicleInfo.split("|");
						if (items.length == 8 || items.length == 11) {
							vehicle = createNewVehicleFromFile(vehicleInfo);
						}
						else {
							vehicle = createUsedVehicleFromFile(vehicleInfo);
						}
						this.soldInventory.add(vehicle);
						scanner.close();
					}
				}catch(FileNotFoundException e) {
					System.out.println("Error reading from file");
				}
		
	}
	
	public UsedVehicle createUsedVehicleFromFile(String vehicleInfo) {
		String[] items = vehicleInfo.split("|");
		UsedVehicle vehicle = new UsedVehicle();
		
		for (int i=0; i<items.length; i++) {
			switch(i) {
			case 0:
				vehicle.setId(Long.parseLong(items[i].trim()));
				break;
			case 1:
				vehicle.setMake(items[i].trim());
				break;
			case 2:
				vehicle.setModel(items[i].trim());
				break;
			case 3:
				vehicle.setaskingPrice(Double.parseDouble(items[i].trim()));
				break;
			case 4:
				vehicle.setDateAddedToCurrInventory(LocalDate.parse(items[i].trim()));
				break;
			case 5:
				vehicle.setDescription(items[i].trim());
				break;
			case 6:
				URL picURL;
				try {
					picURL = new URL(items[i].trim());
					vehicle.setPicURL(picURL);
					vehicle.setPic(ImageIO.read(picURL));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 7:
				vehicle.setEligibleForBid(Boolean.parseBoolean(items[i].trim()));
			case 8:
				if (items.length == 13) {
					vehicle.setPriceSold(Double.parseDouble(items[i].trim()));
				}
				else {
					vehicle.setMiles(Integer.parseInt(items[i].trim()));
				}
				break;
			case 9:
				if (items.length == 13) {
					String[] items2 = items[i].trim().split(",");
					Buyer buyer = new Buyer(items2[0], items2[1], items2[2], Long.parseLong(items2[3]));
					vehicle.setBuyer(buyer);					
				}
				else {
					vehicle.setKbbCondition(KbbCondition.valueOf(items[i].trim()));
				}
				break;
			case 10:
				vehicle.setDateOfPurchase(LocalDate.parse(items[i].trim()));
				break;
			case 11:
				vehicle.setMiles(Integer.parseInt(items[i].trim()));
				break;
			case 12:
				vehicle.setKbbCondition(KbbCondition.valueOf(items[i].trim()));
			}
		}
		return vehicle;
	}
	
	public NewVehicle createNewVehicleFromFile(String vehicleInfo) {
		String[] items = vehicleInfo.split("|");
		NewVehicle vehicle = new NewVehicle();
		
		for (int i=0; i<items.length; i++) {
			switch(i) {
			case 0:
				vehicle.setId(Long.parseLong(items[i].trim()));
				break;
			case 1:
				vehicle.setMake(items[i].trim());
				break;
			case 2:
				vehicle.setModel(items[i].trim());
				break;
			case 3:
				vehicle.setaskingPrice(Double.parseDouble(items[i].trim()));
				break;
			case 4:
				vehicle.setDateAddedToCurrInventory(LocalDate.parse(items[i].trim()));
				break;
			case 5:
				vehicle.setDescription(items[i].trim());
				break;
			case 6:
				URL picURL;
				try {
					picURL = new URL(items[i].trim());
					vehicle.setPicURL(picURL);
					vehicle.setPic(ImageIO.read(picURL));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 7:
				vehicle.setEligibleForBid(Boolean.parseBoolean(items[i].trim()));
				break;
			case 8:
				vehicle.setPriceSold(Double.parseDouble(items[i].trim()));
				break;
			case 9:
				String[] items2 = items[i].trim().split(",");
				Buyer buyer = new Buyer(items2[0], items2[1], items2[2], Long.parseLong(items2[3]));
				vehicle.setBuyer(buyer);					
				break;
			case 10:
				vehicle.setDateOfPurchase(LocalDate.parse(items[i].trim()));
				break;				
			}
		}
		return vehicle;
	}

}
