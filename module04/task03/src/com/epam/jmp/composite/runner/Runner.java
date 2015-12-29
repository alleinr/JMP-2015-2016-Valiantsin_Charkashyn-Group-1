package com.epam.jmp.composite.runner;

import com.epam.jmp.composite.facade.Facade;
import com.epam.jmp.composite.model.AstronomicalObject;

public class Runner {

	public static void main(String[] args) {
		
		Facade facade = new Facade();
		AstronomicalObject universe = facade.createUniverse();
		facade.outputUniverse(universe);		
	}

}
