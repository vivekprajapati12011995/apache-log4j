package com.module2;

import org.apache.log4j.Logger;

public class Car {
	
	public static final Logger logger = Logger.getLogger(Car.class.getPackage().getName());
	private String nameOfCar;
	

	public Car(String nameOfCar) {
		this.nameOfCar = nameOfCar;
	}


	public void detailsOfVehicle(){
		logger.info("vehicle details are: "+nameOfCar);
		logger.error("vehicle details are: "+nameOfCar);
		logger.debug("vehicle details are: "+nameOfCar);
		logger.error("vehicle details are: "+nameOfCar);
		logger.fatal("vehicle details are: "+nameOfCar);
		
	}

}
