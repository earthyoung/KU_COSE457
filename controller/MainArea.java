package controller;

import javax.swing.*;
import java.awt.*;

public class MainArea extends JFrame {

    private static MainArea instance;
    private MenuArea menuArea = MenuArea.getInstance();
    private SettingArea settingArea = SettingArea.getInstance();
    private EditorArea editorArea = EditorArea.getInstance();

    private MainArea() {}

    public static MainArea getInstance() {
        if (instance == null) {
            instance = new MainArea();
            instance.setSize(800, 600);
            instance.setVisible(true);
            instance.setLocationRelativeTo(null);
        }
        return instance;
    }

    public void initialize() {
        this.menuArea.initialize();
        this.settingArea.initialize();
        this.editorArea.initialize();
        Container contentPane = instance.getContentPane();
        contentPane.add(this.menuArea, BorderLayout.NORTH);
        contentPane.add(this.editorArea, BorderLayout.CENTER);
    }

}
