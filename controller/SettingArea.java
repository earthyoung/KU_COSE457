package controller;

import models.*;
import java.awt.Color;

public class SettingArea{
	
	public Canvas selectedObject;
	
	private SettingArea() {}
	
	private static class singletonHelper{
		private static final SettingArea INSTANCE=new SettingArea();
	}
	public static SettingArea getInstance() {
		return singletonHelper.INSTANCE;
	}
	
	//called when canvas object updated
	public void objectUpdate(Canvas currentObject) {
		selectedObject=currentObject;
	}
	
	public void sizeChanged(int newWidth, int newHeight) {
		//update EditorArea
	}

	public void colorChanged(Color Colors) {
		//update EditorArea
	}
	
	

}

