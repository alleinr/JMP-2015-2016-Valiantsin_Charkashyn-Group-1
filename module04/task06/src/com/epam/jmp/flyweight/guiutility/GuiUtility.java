package com.epam.jmp.flyweight.guiutility;

import java.awt.Component;
import java.io.File;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class GuiUtility {
	
	public static Component getGui(JList<File> fileList, boolean vertical) {
		fileList.setCellRenderer(new FileRenderer(!vertical));
		return new JScrollPane(fileList);
	}
	
}
