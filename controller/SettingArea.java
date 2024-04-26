package controller;

import java.util.Observable;
import java.util.Observer;

public class SettingArea implements Observer {
	
	private SettingArea() {}

	@Override
	public void update(Observable o, Object arg) {

	}

	private static class singletonHelper{
		private static final SettingArea INSTANCE=new SettingArea();
	}
	public static SettingArea getInstance() {
		return singletonHelper.INSTANCE;
	}

}

