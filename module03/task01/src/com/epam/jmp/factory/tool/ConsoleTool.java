package com.epam.jmp.factory.tool;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleTool {

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
