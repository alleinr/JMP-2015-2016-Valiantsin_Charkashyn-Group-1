package com.epam.jmp.bridge.bridge;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ListDataAPI implements DataAPI{

	@Override
	public JComponent getComponent(String[] data) {
		
		JList<String> list = new JList<String>(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		return list;
	}

}
