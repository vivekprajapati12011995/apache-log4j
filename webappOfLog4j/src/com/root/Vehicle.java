package com.root;

import org.apache.log4j.Logger;

public class Vehicle {
	
	private static final Logger logger = Logger.getRootLogger();
	private String VehicleName;
	
	public Vehicle(String VehicleName){
		this.VehicleName = VehicleName;
	}
	
	public void detailsOfVehicle(){
		
		logger.info("vehicle details are: "+VehicleName);
		logger.error("vehicle details are: "+VehicleName);
		logger.debug("vehicle details are: "+VehicleName);
		logger.warn("vehicle details are: "+VehicleName);
		logger.fatal("vehicle details are: "+VehicleName);
	}
	
	
	
	
	

}
