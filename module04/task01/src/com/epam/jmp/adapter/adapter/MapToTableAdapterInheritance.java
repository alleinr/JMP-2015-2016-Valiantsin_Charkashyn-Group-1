package com.epam.jmp.adapter.adapter;

import java.util.Set;

import com.epam.jmp.adapter.model.Data;
import com.epam.jmp.adapter.model.DataMap;
import com.epam.jmp.adapter.model.DataTable;

public class MapToTableAdapterInheritance implements Data {
	
	@Override
	public DataTable outTo(Data data){
		int size = ((DataMap) data).getMap().size();
		Object[][] values = new Object[size][2];
		String[] columns = {"key", "value"};
		Set<String> keyset = ((DataMap) data).getMap().keySet();
		int i = 0;
		for(String value:keyset){
			values[i][0] = value;
			values[i][1] = ((DataMap) data).getMap().get(value);			
			i++;
		}
		
		return new DataTable(columns, values);
		
	}
}
