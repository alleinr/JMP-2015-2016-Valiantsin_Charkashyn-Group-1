package com.epam.jmp.decorator.frontend;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.epam.jmp.decorator.model.Button;
import com.epam.jmp.decorator.model.InterfaceElement;

public class CustomButtonMouseListener implements MouseListener{
	
	private Button button;
	
	public CustomButtonMouseListener(InterfaceElement element) {
		super();
		this.button = (Button)element;
		this.button.getButton().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		button.getButton().setBorder(button.getBorder());
		button.getButton().setBackground(button.getColor());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		button.getButton().setBorder(null);
		button.getButton().setBackground(null);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
