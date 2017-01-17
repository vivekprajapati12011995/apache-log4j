package com.module3;

import org.apache.log4j.Logger;

public class Bike {
	
	private static final Logger logger = Logger.getLogger(Bike.class.getPackage().getName());
	private String nameOfBike;
	
	
	public Bike(String nameOfBike) {
		this.nameOfBike = nameOfBike;
	}
	
	
	public void detailsOfVehicle(){
		logger.info("vehicle details are: "+nameOfBike);
		logger.error("vehicle details are: "+nameOfBike);
		logger.debug("vehicle details are: "+nameOfBike);
		logger.warn("vehicle details are: "+nameOfBike);
		logger.fatal("vehicle details are: "+nameOfBike);
		
	}

}
