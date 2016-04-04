package com.epam.jpa.task02.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Output {

	public String out() {
		System.out.println("Hi! What do you want? 1 - load clients; 2 - load accounts; 3 - exit");
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
