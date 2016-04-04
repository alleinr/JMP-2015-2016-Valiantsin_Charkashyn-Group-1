package com.epam.jpa.task01.runner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.jpa.task01.menu.ChoiceHandler;
import com.epam.jpa.task01.menu.Output;
import com.epam.jpa.task01.service.EmployeeService;
import com.epam.jpa.task01.service.PersonalService;
import com.epam.jpa.task01.service.UnitService;

public class Runner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"hconf.xml");
		EmployeeService employees = ctx.getBean("employeeService", EmployeeService.class);
		PersonalService personals = ctx.getBean("personalService", PersonalService.class);
		UnitService units = ctx.getBean("unitService", UnitService.class);
		String choice;

		do {
			Output out = new Output();
			choice = out.out();
			ChoiceHandler.handleTheChoice(choice, employees, personals, units);
			System.out.println("Wanna try again? no - exit");
			choice = out.takeInput();
		} while (!choice.equals("no"));
		ctx.close();
	}

}
