package controller;

import models.Observable;
import models.Observer;

public class SettingArea implements Observer {

	private static SettingArea instance;

	private SettingArea() {}

	@Override
	public void update(Observable o) {

	}

	public void initialize() {

	}

	public static SettingArea getInstance() {
		if (instance == null) {
			instance = new SettingArea();
		}
		return instance;
	}

}

