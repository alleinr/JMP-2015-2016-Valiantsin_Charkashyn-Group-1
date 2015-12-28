package com.epam.jmp.decorator.runner;

import javax.swing.JFrame;

import com.epam.jmp.decorator.decorator.ButtonDecorator;
import com.epam.jmp.decorator.frontend.CustomButtonMouseListener;
import com.epam.jmp.decorator.model.Button;
import com.epam.jmp.decorator.model.InterfaceElement;


public class Runner {

	public static void main(String[] args) {
		
		InterfaceElement button =  new ButtonDecorator(new Button()).getElement();		
		CustomButtonMouseListener listener = new CustomButtonMouseListener(button);
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.add(((Button)button).getButton());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
