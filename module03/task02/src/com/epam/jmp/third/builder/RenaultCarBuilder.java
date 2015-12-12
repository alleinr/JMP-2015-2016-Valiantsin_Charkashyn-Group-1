package com.epam.jmp.third.builder;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.third.model.Chair;
import com.epam.jmp.third.model.Coachwork;
import com.epam.jmp.third.model.Engine;
import com.epam.jmp.third.model.SteeringWheel;
import com.epam.jmp.third.model.Wheel;

public class RenaultCarBuilder extends CarBuilder {

	@Override
	public void buildChairs() {
		int quantity = 5;
		List<Chair> chairs = new ArrayList<Chair>(); 
		Chair chair;
		for (int i = 1; i < quantity; i++){
			chair = new Chair();
			chair.setType("leather");
			chairs.add(chair);
		}
		car.setChairs(chairs);
	}

	@Override
	public void buildCoachwork() {
		Coachwork coachwork = new Coachwork();
		coachwork.setMaterial("silver");
		car.setCoachwork(coachwork);		
	}

	@Override
	public void buildEngine() {
		Engine engine = new Engine();
		engine.setCylinders(6);
		car.setEngine(engine);
		
	}

	@Override
	public void buildSteeringWheel() {
		SteeringWheel stWheel = new SteeringWheel();
		stWheel.setType("round");
		car.setSteeringWheel(stWheel);		
	}

	@Override
	public void buildWheels() {
		int quantity = 4;
		List<Wheel> wheels = new ArrayList<Wheel>(); 
		Wheel wheel;
		for (int i = 1; i < quantity; i++){
			wheel = new Wheel();
			wheel.setType("Bridgestone");
			wheels.add(wheel);
		}
		car.setWheels(wheels);		
	}
}
