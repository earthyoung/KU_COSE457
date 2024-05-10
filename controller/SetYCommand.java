package controller;
import javax.swing.JTextField;

import models.*;

public class SetYCommand extends commandRoot{

	public SetYCommand(TShape tshape, JTextField field) {
		super(tshape, field);
		// TODO Auto-generated constructor stub
	}

	
	public void execute() {
		shape.setNewCenter(shape.getCenterX(),Integer.parseInt(this.tfield.getText()));
	}
	
}
