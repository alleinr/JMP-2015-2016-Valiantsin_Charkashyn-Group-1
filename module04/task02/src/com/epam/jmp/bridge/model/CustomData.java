package com.epam.jmp.bridge.model;

import javax.swing.JComponent;

import com.epam.jmp.bridge.bridge.DataAPI;

public class CustomData extends Data{
	
	private String[] data = {"one", "two", "three"};

	public CustomData(DataAPI dataAPI) {
		super(dataAPI);		
	}

	@Override
	public JComponent show() {
		return dataAPI.getComponent(this.data);		
	}

}
