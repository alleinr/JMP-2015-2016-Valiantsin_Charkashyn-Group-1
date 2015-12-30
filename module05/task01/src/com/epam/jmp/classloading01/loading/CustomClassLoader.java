package com.epam.jmp.classloading01.loading;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

public class CustomClassLoader {

	private final static Logger logger = Logger.getLogger(CustomClassLoader.class);

	private Class<?> classToLoad = null;
	private URLClassLoader loader = null;

	public void loadClass(File file) {
		if (loader == null) {
			try {
				URL url = file.toURI().toURL();
				URL[] urls = { url };
				loader = new URLClassLoader(urls, this.getClass().getClassLoader());
			} catch (MalformedURLException e) {
				logger.error("Exception occurred! Details: " + e);
			}
		}
		try {
			classToLoad = Class.forName("oracle.jdbc.driver.OracleDriver", true, loader);
			logger.info("Class details: " + classToLoad.toString());
		} catch (ClassNotFoundException e) {
			logger.error("Exception occurred! Details: " + e);
		} 
	}
}
