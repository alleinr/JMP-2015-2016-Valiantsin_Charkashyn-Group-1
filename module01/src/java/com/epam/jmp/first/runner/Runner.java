package com.epam.jmp.first.runner;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.first.tool.ConsoleOutputter;
import com.epam.jmp.first.tool.LabyrinthCrosser;
import com.epam.jmp.first.tool.TxtReader;
import com.epam.jmp.first.world.Duck;
import com.epam.jmp.first.world.Labyrinth;

public class Runner {

	public static void main(String[] args) {
		Labyrinth labyrinth = new Labyrinth();
		labyrinth.setLab(new TxtReader().readFile());		
		Duck firstDuck = new Duck();
		firstDuck.setName("Firsty");
		firstDuck.setxPosition(0);
		LabyrinthCrosser crosser = new LabyrinthCrosser();
		firstDuck.setyPosititon(crosser.findAStart(labyrinth));
		int result = crosser.makeAPath(firstDuck, labyrinth);
		firstDuck.setResult(result);
		ConsoleOutputter out = new ConsoleOutputter();
		List<Duck> ducks = new ArrayList<>();
		ducks.add(firstDuck);
		out.out(ducks);
	}

}
