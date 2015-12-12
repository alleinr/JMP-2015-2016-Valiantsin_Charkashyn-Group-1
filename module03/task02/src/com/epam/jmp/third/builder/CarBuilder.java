package com.epam.jmp.third.builder;

import com.epam.jmp.third.model.Car;

public abstract class CarBuilder {
	
	protected Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public void createNewCar(){
		car = new Car();
	}
	
	public abstract void buildChairs();
	public abstract void buildCoachwork();
	public abstract void buildEngine();
	public abstract void buildSteeringWheel();
	public abstract void buildWheels();	

}
