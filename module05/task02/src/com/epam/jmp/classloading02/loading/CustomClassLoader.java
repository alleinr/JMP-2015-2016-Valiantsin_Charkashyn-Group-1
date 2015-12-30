package com.epam.jmp.classloading02.loading;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

public class CustomClassLoader extends ClassLoader {

	private final static Logger logger = Logger.getLogger(CustomClassLoader.class);
	private Class<?> classToLoad = null;

	@Override
	public Class<?> loadClass(String jarAddress) {
		try {
			File file = new File(jarAddress);
			URL url = file.toURI().toURL();
			URL[] urls = { url };
			URLClassLoader child = new URLClassLoader(urls, this.getClass().getClassLoader());
			classToLoad = Class.forName("oracle.jdbc.driver.OracleDriver", true, child);			
			logger.info("Class was (re)loaded, details: " + classToLoad);
		} catch (ClassNotFoundException | IOException e) {
			logger.error("Exception occurred! Details: " + e);

		}
		return classToLoad;
	}

	@Override
	public Class<?> findClass(String jarAddress) {

		if (classToLoad == null) {
			logger.info("Class wasn't loaded before, gonna do it nao...");
			classToLoad = loadClass(jarAddress);
		}
		return classToLoad;
	}
}
