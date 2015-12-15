package com.epam.jmp.factory.tool;

public class ConsoleTool {
	
	public String takeInput(){
		String input = System.console().readLine();		
		return input;		
	}
	
}
