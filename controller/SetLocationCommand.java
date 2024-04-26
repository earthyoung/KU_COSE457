package controller;
import models.*;

public class SetLocationCommand implements Command{

	Canvas cans;
	int cX,cY;
	public SetLocationCommand(int x,int y,Canvas canvas) {
		cans=canvas;
		cX=x;
		cY=y;
	}
	
	public void execute() {
		cans.setX(cX);
		cans.setY(cY);
	}
}
