package controller;

import models.TShape;

public class ToBackCommand implements Command{
	
	TShape shape;
	
	public ToBackCommand(TShape tshape) {
		shape=tshape;
	}
	
	
	public void execute() {
		EditorArea.getInstance().shapeToBack(shape);
	}
	
	public void unexecute() {
		EditorArea.getInstance().shapeToFront(shape);
	}
}

