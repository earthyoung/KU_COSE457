package controller;

import models.Observer;

public class SettingArea implements Observer {
	
	private SettingArea() {}


	public void update(int x, int y, int height, int width) {

	}

	private static class singletonHelper{
		private static final SettingArea INSTANCE=new SettingArea();
	}
	public static SettingArea getInstance() {
		return singletonHelper.INSTANCE;
	}

}

