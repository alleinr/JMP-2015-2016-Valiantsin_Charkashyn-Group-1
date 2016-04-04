package com.epam.jpa.task03.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.jpa.task03.menu.ChoiceHandler;
import com.epam.jpa.task03.menu.Output;

public class Runner {

	public static void main(String[] args) {	
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");		
		String choice;		
		do {			
			Output out = new Output();
			choice = out.init();
			ChoiceHandler handler = new ChoiceHandler();
			handler.handleTheChoice(choice);
			System.out.println("Wanna try again? no - exit");
			choice = out.takeInput();
		} while (!choice.equals("no"));

	}

}
