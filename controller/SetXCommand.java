package controller;

import models.*;

public class SetXCommand implements Command{

	int centerX=0;
	int originalX=0;
	TShape shape;
	int coord=0;
	public SetXCommand(TShape tshape, int x , int center) {
		shape=tshape;
		centerX=center;
		originalX=tshape.getCenterX();
		coord=x;
		// TODO Auto-generated constructor stub
	}

	
	public void execute() {
		shape.setNewCenter(coord+shape.getCenterX()-centerX,shape.getCenterY());
	}
	
	public void unexecute() {
		shape.setNewCenter(originalX,shape.getCenterY());
	}
	
}
