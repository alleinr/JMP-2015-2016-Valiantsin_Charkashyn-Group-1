package com.epam.jpa.task01.menu;

import java.util.List;

import com.epam.jpa.task01.model.Employee;
import com.epam.jpa.task01.model.Unit;
import com.epam.jpa.task01.service.EmployeeService;
import com.epam.jpa.task01.service.PersonalService;
import com.epam.jpa.task01.service.UnitService;

public class ChoiceHandler {

	public static void handleTheChoice(String stringChoice, EmployeeService employees, PersonalService personals, UnitService units) {
		int choice = Integer.parseInt(stringChoice);

		switch (choice) {
		case 1:
			// load employees
			List<Employee> employeeList = employees.getAll();
			for (Employee employee: employeeList){
				System.out.println(employee);
			}
			break;
		case 2:
			//load units
			List<Unit> unitList = units.getAll();
			for (Unit unit: unitList){
				System.out.println(unit);
			}
			break;
		case 3:
			// exit
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice...");
			break;
		}
	}
}
