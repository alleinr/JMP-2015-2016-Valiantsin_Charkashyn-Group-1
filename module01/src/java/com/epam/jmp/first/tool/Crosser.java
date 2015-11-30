package com.epam.jmp.first.tool;

import com.epam.jmp.first.world.Duck;
import com.epam.jmp.first.world.Labyrinth;

public interface Crosser {		
	int makeAPath(Duck duck, Labyrinth labyrinth);
	int findAStart(Labyrinth labyrinth);
}
