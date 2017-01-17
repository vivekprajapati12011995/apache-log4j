package com.log4jweb.services;

public class LoggerDetails {
	
	private int id;
	private String moduleName;
	private String level;
	private boolean additivity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAdditivity() {
		return additivity;
	}
	public void setAdditivity(boolean additivity) {
		this.additivity = additivity;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getLevel() {
		return level;
	}
	public  void setLevel(String level) {
		this.level = level;
	}
	
	

}
