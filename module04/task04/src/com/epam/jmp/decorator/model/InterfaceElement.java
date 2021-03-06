package com.epam.jmp.decorator.model;

import java.awt.Color;
import javax.swing.border.Border;

public interface InterfaceElement {

	Color getColor();
	Border getBorder();
	void setColor(Color color);
	void setBorder(Border border);

}
