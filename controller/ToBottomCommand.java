package controller;

import models.TShape;

public class ToBottomCommand implements Command{
	
	TShape shape;
	TShape bottomShape;
	public ToBottomCommand(TShape tshape) {
		shape=tshape;
		bottomShape=EditorArea.getInstance().getTop();
	}
	
	
	public void execute() {
		EditorArea.getInstance().shapeToBottom(shape);
	}
	
	public void unexecute() {
		EditorArea.getInstance().shapeToBottom(bottomShape);
	}

}

