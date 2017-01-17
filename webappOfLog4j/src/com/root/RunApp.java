package com.root;

import com.module1.Cycle;
import com.module2.Car;
import com.module3.Bike;
import com.module3.Scooty;

public class RunApp {
	public static void start() {

		Vehicle vehicle = new Vehicle("vehicle");
		vehicle.detailsOfVehicle();
		
		Cycle cycle = new Cycle("hero");
		cycle.detailsOfCycle();
		
		Bike bike = new Bike("Yamaha");
		bike.detailsOfVehicle();
		
		Scooty scooty = new Scooty("activa");
		scooty.detailsOfScooty();
		
		Car car = new Car("hyundai");
		car.detailsOfVehicle();
	
	}
	
}


