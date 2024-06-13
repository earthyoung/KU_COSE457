package controller;

import models.TShape;

import java.awt.Color;

public class SetColorCommand implements Command{
	
	TShape shape;
	Color color;
	Color originalColor;
	
	public SetColorCommand(TShape tshape,Color color) {
		shape=tshape;
		this.originalColor=tshape.getShapeColor();
		this.color=color;
	}
	
	
	public void execute() {
		shape.setShapeColor(color);
	}
	
	public void unexecute() {
		shape.setShapeColor(originalColor);
	}
	

}
