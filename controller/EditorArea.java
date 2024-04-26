package controller;

import java.util.Observable;
import java.util.Observer;

public class EditorArea implements Observer {

    private EditorArea() {}

    private static EditorArea getInstance() {
        return new EditorArea();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
