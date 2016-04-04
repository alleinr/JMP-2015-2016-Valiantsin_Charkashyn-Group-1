package com.epam.jpa.task02.runner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.jpa.task02.menu.ChoiceHandler;
import com.epam.jpa.task02.menu.Output;
import com.epam.jpa.task02.service.AccountService;
import com.epam.jpa.task02.service.ClientService;

public class Runner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"hconf.xml");
		AccountService accounts = ctx.getBean("accountService", AccountService.class);
		ClientService clients = ctx.getBean("clientService", ClientService.class);
		String choice;

		do {
			Output out = new Output();
			choice = out.out();
			ChoiceHandler.handleTheChoice(choice, accounts, clients);
			System.out.println("Wanna try again? no - exit");
			choice = out.takeInput();
		} while (!choice.equals("no"));
		ctx.close();
	}

}
