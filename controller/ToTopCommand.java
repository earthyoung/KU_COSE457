package controller;

import models.TShape;

public class ToTopCommand implements Command{
	
	TShape shape;
	TShape topShape;
	public ToTopCommand(TShape tshape) {
		shape=tshape;
		topShape=EditorArea.getInstance().getTop();
	}
	
	
	public void execute() {
		EditorArea.getInstance().shapeToTop(shape);
	}
	
	public void unexecute() {
		EditorArea.getInstance().shapeToTop(topShape);
	}

}
