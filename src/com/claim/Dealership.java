package com.claim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
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
	private ArrayList<Vehicle> soldInventory;
	private long latestVehicleId;
	//to do: read in employees and parse employee info
	private ArrayList<Employee> employees;
	private int latestEmployeeId;
	
	public Dealership() {
		this.newInventory = new ArrayList<NewVehicle>();
		this.usedInventory = new ArrayList<UsedVehicle>();
		this.soldInventory = new ArrayList<Vehicle>();
		this.employees = new ArrayList<Employee>();
		this.latestEmployeeId = 1000;
	}
	
	public Dealership(String name, ArrayList<NewVehicle> newInventory, ArrayList<UsedVehicle> usedInventory,
			 ArrayList<Vehicle> soldInventory, long latestVehicleId, ArrayList<Employee> employees, int latestEmployeeId) { 
		this.name = name;
		this.newInventory = newInventory; 
		this.usedInventory = usedInventory;
		this.soldInventory = soldInventory;
		this.latestVehicleId = latestVehicleId;
		this.employees = employees;
		this.latestEmployeeId = latestEmployeeId;
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
	public ArrayList<Vehicle> getSoldInventory() {
		return soldInventory;
	}
	public void setSoldInventory(ArrayList<Vehicle> soldInventory) {
		this.soldInventory = soldInventory;
	}
	public long getLatestID() {
		return this.latestVehicleId;
	}
	public void setLatestID(long latestVehicleId) {
		this.latestVehicleId = latestVehicleId;
	}
	
	public Vehicle getVehicleById(long id) {
		for(Vehicle vehicle : this.newInventory) {
	        if(vehicle.getId() == id) {
	            return vehicle;
	        }
	    }
		for(Vehicle vehicle : this.usedInventory) {
	        if(vehicle.getId() == id) {
	            return vehicle;
	        }
	    }
		for(Vehicle vehicle : this.soldInventory) {
	        if(vehicle.getId() == id) {
	            return vehicle;
	        }
	    }
	    return null;
	}
	
	//MAY GET RID OF THIS IF DON'T USE IT IN SELLVEHICLE METHOD
	public String getInventoryByVehicleId(long id) {
		for(Vehicle vehicle : this.newInventory) {
	        if(vehicle.getId() == id) {
	            return "new";
	        }
	    }
		for(Vehicle vehicle : this.usedInventory) {
	        if(vehicle.getId() == id) {
	            return "used";
	        }
	    }
	    return null;
	}
	
	//to do: COULD PROBABLY MAKE ALL THE INVENTORIES HASHSETS INSTEAD IF JUST ADDING AND REMOVING AND PRINTING (sorted hashset)

//	public void addToInventory(//all details for vehicle?) {
//		//LOOK BACK AT HOW I DID LIBRARY AND PHONEBOOK
//		//make a Vehicle with these details
//		//set id & everything else
//		//update most recent id
//		//if the vehicle is a newVehicle add to newInventory  //TO DO: How do I do this?
//		//if the vehicle is a usedVehicle add to used
//		//set dateAddedToInventory to today
//	}
	
	//addEmployee method which assigns the next id number 
	public void addEmployee(String firstName, String lastName, String email, long phoneNumber) {
		Employee employee = new Employee(firstName, lastName, email, phoneNumber);
		employee.setEmployeeId(++latestEmployeeId);
		employees.add(employee);
	}
	
	public void sellVehicle(Vehicle vehicle, Buyer buyer, double priceSold) {
//		//TO DO: SEE IF IT STILL WORKS WITHOUT THIS (IT SHOULD B/C REFERENCE TYPE)
//		Vehicle vehicle = this.getVehicleById(vehicle.getId());
		//update dateOfPurchase
		vehicle.setDateOfPurchase(LocalDate.now());
		//update buyer
		vehicle.setBuyer(buyer);
		//update price sold
		vehicle.setPriceSold(priceSold);
		//transfer from from current to sold inventory
		this.newInventory.remove(vehicle);
		this.usedInventory.remove(vehicle);
		this.soldInventory.add(vehicle);
		//write inventories to file
		saveAllToFiles();
	} 
	
	public ArrayList<String> getAllModels() {
		ArrayList<String> allModels = new ArrayList<String>();
		for (Vehicle vehicle : this.newInventory) {
			//this may not work if it's not based on .equals
			if (!allModels.contains(vehicle.getModel()))
				allModels.add(vehicle.getModel());
		}
		for (Vehicle vehicle : this.usedInventory) {
			//this may not work if it's not based on .equals
			if (!allModels.contains(vehicle.getModel()))
				allModels.add(vehicle.getModel());
		}
		return allModels;
	}
	
	//can I use this with a checkbox select(and read it in as an array of Models?)   
	public ArrayList<Vehicle> getVehiclesOfModel(String model, boolean includeNew, boolean includeUsed) {
		ArrayList<Vehicle> modelArray = new ArrayList<Vehicle>();
		if (includeNew == true) {
			for (Vehicle vehicle : this.newInventory) {
				if (vehicle.getModel().equals(model)) {
					modelArray.add(vehicle);
				}
			}
		}
		if (includeUsed == true) {
			for (Vehicle vehicle : this.usedInventory) {
				if (vehicle.getModel().equals(model)) {
					modelArray.add(vehicle);
				}
			}
		}
		return modelArray;
	}
	
	//to do: simplify this by doing something more similar to phonebook app
	//I tried to condense it into a simpler method saveArrayListToFile.. but the casting and generalization didn't work
//	public void saveAllInventoriesToFiles() {
//		String path = "C:\\Users\\Charmaine\\Documents\\Dealership files\\";
//		
//		//for new vehicles
//		String filePath = path + "newVehicles" + ".txt";
//		//BW takes a FW argument
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//			String inventoryString = "";
//			//adds each Vehicle to the string using the Vehicle's formatData method
//			for (Vehicle vehicle : this.newInventory) {
//				inventoryString += (vehicle.formatData() + "\n");
//			}
//			bw.write(inventoryString);
//			bw.close();  
//		}catch (IOException e) {
//			System.out.println("Error writing to file");
//		}
//		
//		//for used vehicles
//		filePath = path + "usedVehicles" + ".txt";
//		//BW takes a FW argument
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//			String inventoryString = "";
//			//adds each Vehicle to the string using the Vehicle's formatData method
//			for (Vehicle vehicle : this.usedInventory) {
//				inventoryString += (vehicle.formatData() + "\n");
//			}
//			bw.write(inventoryString);
//			bw.close();  
//		}catch (IOException e) {
//			System.out.println("Error writing to file");
//		}
//		
//		//for sold vehicles
//		filePath = path + "soldVehicles" + ".txt";
//		//BW takes a FW argument
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//			String inventoryString = "";
//			//adds each Vehicle to the string using the Vehicle's formatData method
//			for (Vehicle vehicle : this.soldInventory) {
//				inventoryString += (vehicle.formatData() + "\n");
//			}
//			bw.write(inventoryString);
//			bw.close();  
//		}catch (IOException e) {
//			System.out.println("Error writing to file");
//		}
//				
//		//for employees
//		String filePath = path + "employees" + ".txt";
//		//BW takes a FW argument
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//			String employeeString = "";
//			//adds each Vehicle to the string using the Vehicle's formatData method
//			for (Employee employee : this.employees) {
//				employeeString += (employee.formatData() + "\n");
//			}
//			bw.write(employeeString);
//			bw.close();  
//		}catch (IOException e) {
//			System.out.println("Error writing to file");
//		}
//	}
	
	public void saveAllToFiles() {
		Vehicle[] array = new Vehicle[this.newInventory.size()];
		int i = 0;
		for (Vehicle vehicle : this.newInventory) {
			array[i++] = vehicle;
		}
		saveInventoryToFile("newVehicles", array);
		
		array = new Vehicle[this.usedInventory.size()];
		i = 0;
		for (Vehicle vehicle : this.usedInventory) {
			array[i++] = vehicle;
		}
		saveInventoryToFile("usedVehicles", array);
		
		array = new Vehicle[this.soldInventory.size()];
		i = 0;
		for (Vehicle vehicle : this.soldInventory) {
			array[i++] = vehicle;
		}
		saveInventoryToFile("soldVehicles", array);
		
		saveEmployeesToFile();
	}
	
	public void saveEmployeesToFile() {
		String path = "C:\\Users\\Charmaine\\Documents\\Dealership files\\";
		String filePath = path + "employees" + ".txt";
		//BW takes a FW argument
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			String employeeString = "";
			//adds each Vehicle to the string using the Vehicle's formatData method
			for (Employee employee : this.employees) {
				employeeString += (employee.formatData() + "\n");
			}
			bw.write(employeeString);
			bw.close();  
		}catch (IOException e) {
			System.out.println("Error writing to file");
		}
	}

	public static void saveInventoryToFile(String fileName, Vehicle[] array) {
		String path = "C:\\Users\\Charmaine\\Documents\\Dealership files\\";
		
		String filePath = path + fileName + ".txt";
		//BW takes a FW argument
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			String resultString = "";
			//adds each Vehicle to the string using the Vehicle's formatData method
			for (int i=0; i<array.length; i++) {
				resultString += (array[i].formatData() + "\n");
			}
			bw.write(resultString);
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
			}
			scanner.close();
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
			}
			scanner.close();
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
				String[] items = vehicleInfo.split(",");
				if (items.length == 8 || items.length == 11) {
					vehicle = createNewVehicleFromFile(vehicleInfo);
				}
				else {
					vehicle = createUsedVehicleFromFile(vehicleInfo);
				}
				this.soldInventory.add(vehicle);
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error reading from file");
		}
		
		//for employees
		filePath = path + "employees" + ".txt";
		try {
			//this scanner is taking in a new file
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNextLine()) {
				String employeeInfo = scanner.nextLine();
				Employee employee = createNewEmployeeFromFile(employeeInfo);
				this.employees.add(employee);
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error reading from file");
		}
		
	}
	
	public Employee createNewEmployeeFromFile(String employeeInfo) {
		String[] items = employeeInfo.split("@@");
		return new Employee(items[1].trim(), items[2].trim(), items[3].trim(), 
				Long.parseLong(items[4].trim()), Integer.parseInt(items[0].trim()));
	}
	
	//to do: TRY TO CONSOLIDATE THE TOP PARTS
	public UsedVehicle createUsedVehicleFromFile(String vehicleInfo) {
		String[] items = vehicleInfo.split(",");
		UsedVehicle vehicle = new UsedVehicle();
		
		for (int i=0; i<items.length; i++) {
			switch(i) {
			case 0:
				vehicle.setId(Long.parseLong(items[i].trim()));
				break;
			case 1: 
				vehicle.setYear(Short.parseShort(items[i].trim()));
				break;
			case 2:
				vehicle.setMake(items[i].trim());
				break;
			case 3:
				vehicle.setModel(items[i].trim());
				break;
			case 4:
				vehicle.setaskingPrice(Double.parseDouble(items[i].trim()));
				break;
			case 5:
				vehicle.setDateAddedToCurrInventory(LocalDate.parse(items[i].trim()));
				break;
			case 6:
				vehicle.setDescription(items[i].trim());
				break;
			case 7:
				try {
					vehicle.setPicURL(new URL(items[i].trim()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
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
					String[] items2 = items[i].trim().split(";");
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
			//TO DO: WHY DON'T WE PUT THE SALE INFO AT THE END FOR ALL?
		}
		return vehicle;
	}
	
	public NewVehicle createNewVehicleFromFile(String vehicleInfo) {
		String[] items = vehicleInfo.split(",");
		NewVehicle vehicle = new NewVehicle();
		
		for (int i=0; i<items.length; i++) {
			switch(i) {
			case 0:
				vehicle.setId(Long.parseLong(items[i].trim()));
				break;
			case 1: 
				vehicle.setYear(Short.parseShort(items[i].trim()));
				break;
			case 2:
				vehicle.setMake(items[i].trim());
				break;
			case 3:
				vehicle.setModel(items[i].trim());
				break;
			case 4:
				vehicle.setaskingPrice(Double.parseDouble(items[i].trim()));
				break;
			case 5:
				vehicle.setDateAddedToCurrInventory(LocalDate.parse(items[i].trim()));
				break;
			case 6:
				vehicle.setDescription(items[i].trim());
				break;
			case 7:
				try {
					vehicle.setPicURL(new URL(items[i].trim()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
			case 8:
				vehicle.setPriceSold(Double.parseDouble(items[i].trim()));
				break;
			case 9:
				String[] items2 = items[i].trim().split(";");
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

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public int getLatestEmployeeId() {
		return latestEmployeeId;
	}

	public void setLatestEmployeeId(int latestEmployeeId) {
		this.latestEmployeeId = latestEmployeeId;
	}

}
