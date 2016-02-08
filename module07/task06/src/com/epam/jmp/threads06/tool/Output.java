package com.epam.jmp.threads06.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Output {

	
	public String init() {
		System.out.println("Hi! Please enter size:");
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
