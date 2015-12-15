package com.epam.jmp.factory.runner;

import com.epam.jmp.factory.facade.Facade;


public class Runner {
	
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.doTheThing();
	}
}
