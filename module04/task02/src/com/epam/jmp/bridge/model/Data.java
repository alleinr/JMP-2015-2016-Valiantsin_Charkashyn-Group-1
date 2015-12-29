package com.epam.jmp.bridge.model;

import javax.swing.JComponent;

import com.epam.jmp.bridge.bridge.DataAPI;

public abstract class Data {
	
	protected DataAPI dataAPI;
	
	protected Data(DataAPI dataAPI){
		this.dataAPI = dataAPI;
	}
	
	public abstract JComponent show();
}
