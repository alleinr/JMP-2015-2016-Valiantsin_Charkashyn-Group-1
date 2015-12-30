package com.epam.jmp.classloading01.tool;

import java.io.File;
import com.epam.jmp.classloading01.loading.CustomClassLoader;
import org.apache.log4j.Logger;

public class ChoiceHandler {

	private final static Logger logger = Logger.getLogger(ChoiceHandler.class);

	public static void handleTheChoice(String stringChoice) {
		int choice = Integer.parseInt(stringChoice);

		switch (choice) {
		case 1:
			// load class
			logger.info("Loading class...");
			File file = new File("ojdbc6-11.2.0.2.0.jar");
			new CustomClassLoader().loadClass(file);
			break;
		case 2:
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
