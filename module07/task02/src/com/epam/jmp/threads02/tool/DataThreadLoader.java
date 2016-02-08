package com.epam.jmp.threads02.tool;


public class DataThreadLoader extends Thread {

	public void run() {		
			XMLLoader loader = new XMLLoader();
			loader.load();
	}

}
