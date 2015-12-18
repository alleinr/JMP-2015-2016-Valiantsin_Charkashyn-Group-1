package com.epam.jmp.facade.runner;

import com.epam.jmp.facade.facade.Facade;


public class Runner {
	
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.connect();
	}
}
