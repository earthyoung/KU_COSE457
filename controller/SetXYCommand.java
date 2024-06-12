package controller;

import models.TShape;

public class SetXYCommand implements Command{

	TShape shape;
	int curX,curY;
	int originX,originY;
	
	public SetXYCommand(TShape tshape, int x , int y) {
		shape=tshape;
		originX=x;
		originY=y;
		curX=shape.getCenterX();
		curY=shape.getCenterY();
	}
	
	public void execute() {
		shape.setNewCenter(curX,curY);
	}
	
	public void unexecute() {
		shape.setNewCenter(originX,originY);
	}
}
