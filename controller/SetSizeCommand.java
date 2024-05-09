package controller;

import models.*;
import javax.swing.*;

public class SetSizeCommand extends commandRoot{
	
	public SetSizeCommand(TShape tshape, JTextField field) {
		super(tshape, field);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		this.shape.setSize(Float.parseFloat(this.tfield.getText()));
	}
}
