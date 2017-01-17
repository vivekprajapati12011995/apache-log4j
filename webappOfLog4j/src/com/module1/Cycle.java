package com.module1;

import org.apache.log4j.Logger;

public class Cycle {
	
	public static final Logger logger = Logger.getLogger(Cycle.class.getPackage().getName());
	private String nameOfCycle;

	public Cycle(String nameOfCycle) {
		this.nameOfCycle = nameOfCycle;
	}
	
	public void detailsOfCycle(){
		
		logger.info("vehicle details are: "+nameOfCycle);
		logger.error("vehicle details are: "+nameOfCycle);
		logger.debug("vehicle details are: "+nameOfCycle);
		logger.error("vehicle details are: "+nameOfCycle);
		logger.fatal("vehicle details are: "+nameOfCycle);
		
	}


	
	
}
