package com.epam.jmp.adapter.adapter;

import java.util.Set;

import com.epam.jmp.adapter.model.DataMap;
import com.epam.jmp.adapter.model.DataTable;

public class MapToTableAdapterComposition {
	
	private DataTable table;
	
	public MapToTableAdapterComposition(){
		table = new DataTable();
	}

	public DataTable getTable() {
		return table;
	}

	public void setTable(DataTable table) {
		this.table = table;
	}
	
	public DataTable convertMapToTable(DataMap map){
		int size = map.getMap().size();
		Object[][] values = new Object[size][2];
		String[] columns = {"key", "value"};
		Set<String> keyset = map.getMap().keySet();
		int i = 0;
		for(String value:keyset){
			values[i][0] = value;
			values[i][1] = map.getMap().get(value);			
			i++;
		}
		
		return new DataTable(columns, values);
		
	}
}
