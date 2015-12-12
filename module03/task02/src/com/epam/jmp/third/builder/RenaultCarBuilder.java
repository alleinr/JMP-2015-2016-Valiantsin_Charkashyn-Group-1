package com.epam.jmp.third.builder;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.third.model.Chair;
import com.epam.jmp.third.model.Coachwork;

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
		Coachwork c = new Coachwork();
		c.setMaterial("Silver");
		car.setCoachwork(c);		
	}

	@Override
	public void buildEngine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildSteeringWheel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildWheels() {
		// TODO Auto-generated method stub
		
	}

}
