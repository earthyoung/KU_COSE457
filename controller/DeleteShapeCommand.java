package controller;

import models.TShape;

public class DeleteShapeCommand implements Command{

	TShape shape;
	public DeleteShapeCommand(TShape tshape) {
		shape=tshape;
	}
	
	
	public void execute() {
		EditorArea.getInstance().delete(shape);
	}
	
	public void unexecute() {
		EditorArea.getInstance().undelete();
	}
	
}
