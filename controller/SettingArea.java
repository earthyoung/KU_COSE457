package controller;

import models.*;
import java.awt.Color;

public class SettingArea implements Observer{
	
	private SettingArea() {}
	
	private static class singletonHelper{
		private static final SettingArea INSTANCE=new SettingArea();
	}
	public static SettingArea getInstance() {
		return singletonHelper.INSTANCE;
	}
	
	@Override
	public void update(int x,int y,int width,int height) {
	//update when size changed
		
		
	}
	
}

