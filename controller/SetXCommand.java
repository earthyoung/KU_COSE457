package controller;
import javax.swing.JTextField;

import models.*;

public class SetXCommand extends commandRoot{

	int centerX=0;
	public SetXCommand(TShape tshape, JTextField field , int center) {
		super(tshape, field);
		centerX=center;
		// TODO Auto-generated constructor stub
	}

	
	public void execute() {
		shape.setNewCenter(Integer.parseInt(this.tfield.getText())+shape.getCenterX()-centerX,shape.getCenterY());
	}
	
}
