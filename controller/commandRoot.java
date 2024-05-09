package controller;

import models.*;
import javax.swing.*;

abstract public class commandRoot implements Command {
	
	JTextField tfield;
	TShape shape;
	public commandRoot(TShape tshape,JTextField field) {
		this.shape=tshape;
		this.tfield=field;
	}
	
}