package com.epam.jmp.threads01.runner;

import com.epam.jmp.threads01.menu.ChoiceHandler;
import com.epam.jmp.threads01.menu.Output;
import com.epam.jmp.threads01.model.Bank;
import com.epam.jmp.threads01.tool.DataThreadLoader;

public class Runner {

	public static void main(String[] args) {	
		
		DataThreadLoader loader = new DataThreadLoader();
		loader.run();
		Bank bank = Bank.getInstance();
		System.out.println(bank);
		String choice;		
		do {			
			Output out = new Output();
			choice = out.init();
			ChoiceHandler.handleTheChoice(choice);
			System.out.println(bank);
			System.out.println("Wanna try again? no - exit");
			choice = out.takeInput();
		} while (!choice.equals("no"));

	}

}
