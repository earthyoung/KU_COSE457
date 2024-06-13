package controller;

import models.*;
import javax.swing.*;

public class SetSizeCommand implements Command{
	
	float originalSize;
	float size;
	TShape shape;
	public SetSizeCommand(TShape tshape, float Size) {
		this.shape=tshape;
		this.size=Size;
		originalSize=shape.getSize();
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		this.shape.setSize(size);
	}
	
	public void unexecute() {
		this.shape.setSize(originalSize);
	}

}
