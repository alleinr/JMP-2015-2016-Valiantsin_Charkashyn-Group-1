package com.epam.jmp.threads02.tool;

import com.epam.jmp.threads02.dao.PersonDAO;

public class ClientThreadUploader extends Thread{
	
	private Object data;	
	
	public ClientThreadUploader(Object data) {
		super();
		this.data = data;
	}
	
	public ClientThreadUploader(){
		
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public void run(){
		PersonDAO dao = new PersonDAO();
		dao.saveObject(data);
	}
}
