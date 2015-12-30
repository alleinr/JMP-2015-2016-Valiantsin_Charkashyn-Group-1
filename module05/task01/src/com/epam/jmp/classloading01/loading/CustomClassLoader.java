package com.epam.jmp.classloading01.loading;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

public class CustomClassLoader {

	private final static Logger logger = Logger.getLogger(CustomClassLoader.class);

	public void loadClass(File file) {
		Class<?> classToLoad = null;
		try {
			URL url = file.toURI().toURL();
			URL[] urls = { url };
			URLClassLoader child = new URLClassLoader(urls, this.getClass().getClassLoader());
			classToLoad = Class.forName("oracle.jdbc.driver.OracleDriver", true, child);
			logger.info("Class details: " + classToLoad.toString());
		} catch (ClassNotFoundException | MalformedURLException e) {
			logger.error("Exception occurred! Details: " + e);
		}		
	}

}
