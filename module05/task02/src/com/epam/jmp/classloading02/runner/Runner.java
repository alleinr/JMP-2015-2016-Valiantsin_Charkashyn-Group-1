package com.epam.jmp.classloading02.runner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.epam.jmp.classloading02.tool.ChoiceHandler;
import com.epam.jmp.classloading02.tool.Output;

public class Runner {

	private final static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) {
		new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());

		String choice;
		do {
			Output out = new Output();
			choice = out.out();
			ChoiceHandler.handleTheChoice(choice);
			logger.info("Wanna try again? no - exit");
			choice = out.takeInput();
		} while (!choice.equals("no"));

	}

}
