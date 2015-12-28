package com.epam.jmp.decorator.decorator;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.epam.jmp.decorator.model.InterfaceElement;

public class ButtonDecorator extends Decorator{	
	private Color color; 
	private Border border; 

public ButtonDecorator(InterfaceElement element) {
		super(element);		
		color =  Color.PINK;
		border = new LineBorder(Color.RED, 12);
	}

	@Override
	public Color getColor() {		
		return color;
	}

	@Override
	public Border getBorder() {
		return border;
	}

	@Override
	public InterfaceElement getElement() {
		element.setColor(color);
		element.setBorder(border);
		return super.getElement();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		
	}

	@Override
	public void setBorder(Border border) {
		this.border = border;		
	}
	
	
}
