package controller;

import models.TShape;

import java.awt.Color;

public class SetColorCommand implements Command{
	
	TShape shape;
	Color color;
	
	public SetColorCommand(TShape tshape,Color color) {
		shape=tshape;
		this.color=color;
	}
	
	
	public void execute() {
		shape.setShapeColor(color);
	}

}
