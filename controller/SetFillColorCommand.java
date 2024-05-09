package controller;

import models.TShape;

import java.awt.Color;

public class SetFillColorCommand implements Command{
	
	TShape shape;
	Color color;
	
	public SetFillColorCommand(TShape tshape,Color color) {
		shape=tshape;
		this.color=color;
	}
	
	
	public void execute() {
		shape.setShapefillColor(color);
	}

}
