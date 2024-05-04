package controller;

import models.Observable;
import models.Observer;

public class SettingArea implements Observer {
	
	private SettingArea() {}

	@Override
	public void update(Observable o) {

	}

	public void initialize() {

	}

	private static class singletonHelper{
		private static final SettingArea INSTANCE=new SettingArea();
	}
	public static SettingArea getInstance() {
		return singletonHelper.INSTANCE;
	}

}

