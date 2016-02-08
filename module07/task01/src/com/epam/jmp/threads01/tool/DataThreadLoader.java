package com.epam.jmp.threads01.tool;

import com.epam.jmp.threads01.tool.loading.XMLLoader;

public class DataThreadLoader extends Thread {

	public void run() {		
			XMLLoader loader = new XMLLoader();
			loader.load();
	}

}
