package controller;

import models.*;

public class SetYCommand implements Command{

	int centerY=0;
	int originalY=0;
	TShape shape;
	int coord=0;
	public SetYCommand(TShape tshape, int y, int center) {
		this.shape=tshape;
		coord=y;
		centerY=center;
		originalY=shape.getCenterY();
		// TODO Auto-generated constructor stub
	}

	
	public void execute() {
		shape.setNewCenter(shape.getCenterX(),coord+shape.getCenterY()-centerY);
	}
	
	public void unexecute() {
		shape.setNewCenter(shape.getCenterX(),originalY);
	}
}
