package com.epam.jmp.decorator.model;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.Border;

public class Button implements InterfaceElement{
	
	private JButton button;
	private Color color;
	private Border border;
	

	public Button() {
			button = new JButton("ButtonDefault");
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public void setBorder(Border border) {
		this.border = border;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public Color getColor() {
		return color;
	}

	public Border getBorder() {
		return border;
	}

}
