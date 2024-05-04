package controller;

import javax.swing.*;

public class MenuArea extends JToolBar {

    private static MenuArea instance;

    private MenuArea() {}

    public static MenuArea getInstance() {
        if (instance == null) {
            instance = new MenuArea();
        }
        return instance;
    }

    public void initialize() {
        JButton imageButton = new JButton("image");
        JButton textButton = new JButton("text");
        JButton lineButton = new JButton("line");
        JButton rectangleButton = new JButton("rectangle");
        JButton ellipseButton = new JButton("ellipse");
        instance.add(imageButton);
        instance.add(textButton);
        instance.add(lineButton);
        instance.add(rectangleButton);
        instance.add(ellipseButton);
    }

}
