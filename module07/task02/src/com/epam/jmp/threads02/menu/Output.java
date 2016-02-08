package com.epam.jmp.threads02.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Output {

	
	public String init() {
		System.out.println("Hi! What do you want? 1 - reload bank info; 2 - create account; 3 - create user; 4 - exchange currency");
		return takeInput();
	}
	
	public String enterId() {
		System.out.println("Please enter id:");
		return takeInput();
	}
	
	public String enterFirstName() {
		System.out.println("Please enter first name:");
		return takeInput();
	}
	
	public String enterLastName() {
		System.out.println("Please enter last name:");
		return takeInput();
	}
	
	public String enterStatus() {
		System.out.println("Please enter status:");
		return takeInput();
	}
	
	public String enterCurrency() {
		System.out.println("Please enter currency:");
		return takeInput();
	}
	
	public String enterOwner() {
		System.out.println("Please enter client Id:");
		return takeInput();
	}
	
	public String enterAmount() {
		System.out.println("Please enter amount:");
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
