package com.epam.jmp.third.builder;

import com.epam.jmp.third.model.Car;

public class Director {
	private CarBuilder carBuilder;

	public void setCarBuilder(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	public CarBuilder getCarBuilder() {
		return carBuilder;
	}	

	public Car getCar() {
		return carBuilder.getCar();
	}
	
	public void constructCar(){
		carBuilder.createNewCar();
		carBuilder.buildChairs();
		carBuilder.buildCoachwork();
		carBuilder.buildEngine();
		carBuilder.buildSteeringWheel();
		carBuilder.buildWheels();
	}
}
