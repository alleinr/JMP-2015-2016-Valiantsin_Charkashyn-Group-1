package com.epam.jmp.first.tool;

import java.util.List;

import com.epam.jmp.first.world.Duck;
import com.epam.jmp.first.world.Labyrinth;

public class LabyrinthCrosser implements Crosser{

	@Override
	public int findAStart(Labyrinth labyrinth) {
		List<List<String>> labyrinthScheme = labyrinth.getLab();
		int labyrinthSize = labyrinthScheme.size();
		int startPoint = 0;
		List<String> line;
		for (int i = 0; i < labyrinthSize; i++){
			line = labyrinthScheme.get(i);
			if (line.get(0).equals("e")){
				startPoint = i;	
				break;
			}
		}		
		return startPoint;		
	}

	@Override
	public int makeAPath(Duck duck, Labyrinth labyrinth) {
		
		int path = 0;
		int posX = duck.getxPosition(), posY = duck.getyPosititon();
		List<List<String>> labyrinthScheme = labyrinth.getLab();
		int labyrinthSize = labyrinthScheme.size();
		do {
			if (labyrinthScheme.get(posY+1).get(posX).equals("x")){				
				posX++;				
			} else {
				posY++;
			}
			path++;
		} while (posY+1 < labyrinthSize && posX+1 < labyrinthSize && !labyrinthScheme.get(posY).get(posX).equals("e"));		
		return path;
	}	
}
