package com.epam.jmp.classloading01.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;


public class Output {

	private final static Logger logger = Logger.getLogger(Output.class) ;
	
	public String out() {
		logger.info("Hi! What do you want? 1 - load class; 2 - exit");
		return takeInput();
	}
	
	public String takeInput() {
		String input = null;
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			input = bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}


}
