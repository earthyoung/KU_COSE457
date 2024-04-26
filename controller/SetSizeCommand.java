package controller;

import models.*;

public class SetSizeCommand implements Command {
	
	Canvas cans;
	int cWidth,cHeight;
	
	public SetSizeCommand(int width,int height,Canvas canvas) {
		cans=canvas;
		cWidth=width;
		cHeight=height;
	}
	
	public void execute() {
		cans.setHeight(cWidth);
		cans.setWidth(cHeight);
	}
}
