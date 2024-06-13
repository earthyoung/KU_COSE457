package controller;

import models.TShape;

import java.awt.Color;

public class SetFillColorCommand implements Command{
	
	TShape shape;
	Color color;
	Color originalColor;
	public SetFillColorCommand(TShape tshape,Color color) {
		shape=tshape;
		this.color=color;
		this.originalColor=tshape.getShapefillColor();
	}
	
	
	public void execute() {
		shape.setShapefillColor(color);
	}
	
	public void unexecute() {
		shape.setShapefillColor(originalColor);
	}

}
