package com.epam.jmp.threads02.tool;

import com.epam.jmp.threads02.dao.ExchangeRateDAO;

public class ExchangeRateThreadUploader extends Thread{
	
	private Object data;	
	
	public ExchangeRateThreadUploader(Object data) {
		super();
		this.data = data;
	}
	
	public ExchangeRateThreadUploader(){		
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public void run(){
		ExchangeRateDAO dao = new ExchangeRateDAO();
		dao.saveObject(data);
	}
}
