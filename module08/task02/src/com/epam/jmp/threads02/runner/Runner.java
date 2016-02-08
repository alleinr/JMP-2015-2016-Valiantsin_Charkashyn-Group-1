package com.epam.jmp.threads02.runner;

import com.epam.jmp.threads02.menu.ChoiceHandler;
import com.epam.jmp.threads02.menu.Output;

public class Runner {

	public static void main(String[] args) {
		String choice;		
		do {			
			Output out = new Output();
			choice = out.init();
			try{
			ChoiceHandler.handleTheChoice(choice);
			} catch (IllegalArgumentException e){
				System.out.println(e);
			}
			System.out.println("Wanna try again? no - exit");
			choice = out.takeInput();
		} while (!choice.equals("no"));

	}

}
