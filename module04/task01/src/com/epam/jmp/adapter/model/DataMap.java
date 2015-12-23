package com.epam.jmp.adapter.model;

import java.util.HashMap;

public class DataMap implements Data{
	private HashMap<String, String> map;
	
	public DataMap(){
		map = new HashMap<String, String>();
		for (int i = 0; i < 10; i++){
			map.put("key " + i, "value " + i);
		}
	}

	public HashMap<String, String> getMap() {
		return map;
	} 

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
	@Override
	public Object outTo(Data data){
		return ((DataMap) data).getMap().toString();
	};
}
