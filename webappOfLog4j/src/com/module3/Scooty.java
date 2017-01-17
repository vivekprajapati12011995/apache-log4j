package com.module3;

import org.apache.log4j.Logger;

public class Scooty {
	
	private static final Logger logger = Logger.getLogger(Scooty.class.getPackage().getName());
	private String nameOfScooty;
	
	public Scooty(String nameOfScooty){
		this.nameOfScooty = nameOfScooty;
	}
	
	public void detailsOfScooty(){
		logger.info("vehicle details are: "+nameOfScooty);
		logger.error("vehicle details are: "+nameOfScooty);
		logger.debug("vehicle details are: "+nameOfScooty);
		logger.warn("vehicle details are: "+nameOfScooty);
		logger.fatal("vehicle details are: "+nameOfScooty);
		logger.trace("vehicle details are: "+nameOfScooty);
		
	}


}
