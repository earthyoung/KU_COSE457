package controller;

import models.TShape;

public class ToFrontCommand implements Command{
	
	TShape shape;
	
	public ToFrontCommand(TShape tshape) {
		shape=tshape;
	}
	
	
	public void execute() {
		EditorArea.getInstance().shapeToFront(shape);
	}
	
	public void unexecute() {
		EditorArea.getInstance().shapeToBack(shape);
	}
}
