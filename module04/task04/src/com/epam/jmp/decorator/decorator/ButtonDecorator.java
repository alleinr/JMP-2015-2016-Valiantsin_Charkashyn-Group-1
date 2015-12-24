package com.epam.jmp.decorator.decorator;

import java.awt.Color;

import com.epam.jmp.decorator.model.InterfaceElement;

public abstract class ButtonDecorator implements InterfaceElement{
	
	protected InterfaceElement button;

	public ButtonDecorator(InterfaceElement button) {
		this.button = button;
	}
	
	public Color getColor(){
		return button.getColor();
	}
	
}
