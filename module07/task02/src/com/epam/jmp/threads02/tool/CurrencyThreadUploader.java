package com.epam.jmp.threads02.tool;

import com.epam.jmp.threads02.dao.CurrencyDAO;

public class CurrencyThreadUploader extends Thread{
	
	private Object data;	
	
	public CurrencyThreadUploader(Object data) {
		super();
		this.data = data;
	}
	
	public CurrencyThreadUploader(){
		
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public void run(){
		CurrencyDAO dao = new CurrencyDAO();
		dao.saveObject(data);
	}
}
