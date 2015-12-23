package com.epam.jmp.adapter.model;

import javax.swing.JTable;

public class DataTable implements Data{
	private JTable table;

	public DataTable() {}
	
	public DataTable(String[] columns, Object[][] values){
			table = new JTable(values, columns);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	@Override
	public Object outTo(Data data) {
		return ((DataTable) data).getTable().toString();
	}
	
	
}
