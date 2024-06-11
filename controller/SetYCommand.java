package controller;
import javax.swing.JTextField;

import models.*;

public class SetYCommand extends commandRoot{

	int centerY=0;
	public SetYCommand(TShape tshape, JTextField field, int center) {
		super(tshape, field);
		centerY=center;
		// TODO Auto-generated constructor stub
	}

	
	public void execute() {
		shape.setNewCenter(shape.getCenterX(),Integer.parseInt(this.tfield.getText())+shape.getCenterY()-centerY);
	}
	
}
