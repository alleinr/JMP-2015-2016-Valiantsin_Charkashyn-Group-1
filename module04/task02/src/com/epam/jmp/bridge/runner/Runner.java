package com.epam.jmp.bridge.runner;

import javax.swing.JFrame;

import com.epam.jmp.bridge.bridge.ListDataAPI;
import com.epam.jmp.bridge.bridge.TableDataAPI;
import com.epam.jmp.bridge.model.CustomData;
import com.epam.jmp.bridge.model.Data;

public class Runner {

	public static void main(String[] args) {		
		
		JFrame tableFrame = new JFrame();
		tableFrame.setSize(200, 200);
		tableFrame.setTitle("Table");
		Data table = new CustomData(new TableDataAPI());		
		tableFrame.add(table.show());		
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tableFrame.setVisible(true);
		
		JFrame listFrame = new JFrame();
		listFrame.setSize(200, 200);
		listFrame.setTitle("List");
		Data list = new CustomData(new ListDataAPI());
		listFrame.add(list.show());
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setVisible(true);


	}

}
