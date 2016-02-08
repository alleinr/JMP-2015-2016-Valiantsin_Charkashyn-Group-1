package com.epam.jmp.threads01.tool;

import java.io.File;

import com.epam.jmp.threads01.tool.parsing.JaxbParser;

public class DataThreadUploader extends Thread{
	
	private Object data;	
	private File file;
	
	public DataThreadUploader(Object data, File file) {
		super();
		this.data = data;
		this.file = file;
	}
	
	public DataThreadUploader(){
		
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}	

	public void run(){
		JaxbParser parser = new JaxbParser();
		parser.saveObject(file, data);
	}
}
