package controller;
import javax.swing.JTextField;

import models.*;

public class SetXCommand extends commandRoot{

	public SetXCommand(TShape tshape, JTextField field) {
		super(tshape, field);
		// TODO Auto-generated constructor stub
	}

	
	public void execute() {
		shape.setNewCenter(Integer.parseInt(this.tfield.getText()),shape.getCenterY());
	}
	
}
