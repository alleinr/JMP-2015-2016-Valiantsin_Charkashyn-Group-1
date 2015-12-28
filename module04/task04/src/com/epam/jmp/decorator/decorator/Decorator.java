package com.epam.jmp.decorator.decorator;

import java.awt.Color;

import javax.swing.border.Border;

import com.epam.jmp.decorator.model.InterfaceElement;

public abstract class Decorator implements InterfaceElement {

	protected InterfaceElement element;

	public Decorator(InterfaceElement element) {
		this.element = element;
	}

	@Override
	public Color getColor() {
		return element.getColor();
	}

	@Override
	public Border getBorder() {
		return element.getBorder();
	}
	
	public InterfaceElement getElement(){
		return this.element;
	};

}
