package com.epam.jmp.first.tool;

import java.util.List;

import com.epam.jmp.first.world.Duck;

public class ConsoleOutputter implements Outputter {

	@Override
	public void out(List<Duck> ducks) {
		for (Duck duck: ducks){
			System.out.println("Result of " + duck.getName() + " is " + duck.getResult());
		}
	}
}
