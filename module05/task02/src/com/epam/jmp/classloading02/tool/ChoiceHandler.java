package com.epam.jmp.classloading02.tool;

import org.apache.log4j.Logger;

import com.epam.jmp.classloading02.loading.CustomClassLoader;

public class ChoiceHandler {

	private final static Logger logger = Logger.getLogger(ChoiceHandler.class);

	public static void handleTheChoice(String stringChoice) {
		int choice = Integer.parseInt(stringChoice);

		switch (choice) {
		case 1:
			// find class
			logger.info("Finding class...");
			new CustomClassLoader().findClass("ojdbc6-11.2.0.2.0.jar");
			break;
		case 2:
			//reload class
			logger.info("Reloading class...");
			new CustomClassLoader().loadClass("ojdbc6-11.2.0.2.0.jar");
		case 3:
			// exit
			logger.info("Exit...");
			System.exit(0);
			break;
		default:
			logger.info("Wrong choice...");
			break;
		}
	}
}
