package com.epam.jmp.decorator.decorator;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.epam.jmp.decorator.model.InterfaceElement;

public class ColorButtonDecorator extends ButtonDecorator{

	public ColorButtonDecorator(InterfaceElement button) {
		super(button);
	}

	@Override
	public Color getColor() {		
		return Color.PINK;
	}

	@Override
	public Border getBorder() {
		// TODO Auto-generated method stub
		return new LineBorder(Color.RED, 12);
	}
	
	

}
