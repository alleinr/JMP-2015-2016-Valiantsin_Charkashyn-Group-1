package com.epam.jmp.memory.method;

import com.epam.jmp.memory.model.GreatObject;

public class ReferenceTaker {
	
	/*public void takeAReference(String line){
		
		GreatObject obj = new GreatObject(line);
		
	}
	*/
	
	public GreatObject takeAReference(String line){
		
		return new GreatObject(line);
	}
}
