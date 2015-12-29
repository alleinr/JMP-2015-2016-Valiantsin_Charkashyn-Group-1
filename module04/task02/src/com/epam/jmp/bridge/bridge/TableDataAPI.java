package com.epam.jmp.bridge.bridge;

import javax.swing.JComponent;
import javax.swing.JTable;

public class TableDataAPI implements DataAPI{

	@Override
	public JComponent getComponent(String[] data) {
		
		Object[][] values = new Object[data.length][1];
		String[] columns = {"value"};
		int i = 0;
		for(String value:data){
			values[i][0] = value;		
			i++;
		}
		
		return new JTable(values, columns);
		
	}

}
