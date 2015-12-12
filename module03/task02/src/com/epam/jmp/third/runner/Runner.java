package com.epam.jmp.third.runner;

import com.epam.jmp.third.builder.CarBuilder;
import com.epam.jmp.third.builder.Director;
import com.epam.jmp.third.builder.RenaultCarBuilder;
import com.epam.jmp.third.model.Car;

public class Runner {

	public static void main(String[] args) {
		
		Director director = new Director();
	    CarBuilder renaultBuilder = new RenaultCarBuilder();

	    director.setCarBuilder(renaultBuilder);
	    director.constructCar();

	    Car car = director.getCar();
	    car.print();
	}

}
