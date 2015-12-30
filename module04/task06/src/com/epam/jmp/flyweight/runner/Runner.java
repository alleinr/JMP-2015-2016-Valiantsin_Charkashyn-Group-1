package com.epam.jmp.flyweight.runner;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.epam.jmp.flyweight.factory.FileListFactory;
import com.epam.jmp.flyweight.guiutility.GuiUtility;
import com.epam.jmp.flyweight.model.CustomFileList;
import com.epam.jmp.flyweight.model.FileList;

public class Runner {

	public static void main(String[] args) {

		String address = System.getProperty("user.home");
		FileList fileList = FileListFactory.getFileList(address);
		Component frameComponent = GuiUtility.getGui(((CustomFileList) fileList).getFiles(), true);
		JFrame frame = new JFrame("File List");
		JPanel gui = new JPanel(new BorderLayout());
		gui.add(frameComponent, BorderLayout.CENTER);
		gui.setBorder(new EmptyBorder(3, 3, 3, 3));
		frame.setContentPane(gui);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
