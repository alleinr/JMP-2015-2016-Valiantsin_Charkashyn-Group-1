package com.epam.jmp.adapter.runner;

import javax.swing.JFrame;

import com.epam.jmp.adapter.adapter.MapToTableAdapterComposition;
import com.epam.jmp.adapter.adapter.MapToTableAdapterInheritance;
import com.epam.jmp.adapter.model.DataMap;

public class Runner {

	public static void main(String[] args) {
		
		DataMap map = new DataMap();
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		//frame.add(new MapToTableAdapterInheritance().outTo(map).getTable());
		frame.add(new MapToTableAdapterComposition().convertMapToTable(map).getTable());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
