package controller;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private static final long serialVersionUID = 1L;

    private FileMenu fileMenu;
    private EditMenu editMenu;
    private DrawingAttributeMenu colorMenu;

    private EditorArea editorArea;

    public MenuBar() {
        this.fileMenu = new FileMenu("파일");
        this.add(this.fileMenu);

        this.editMenu = new EditMenu("편집");
        this.add(this.editMenu);

        this.colorMenu = new DrawingAttributeMenu("색상");
        this.add(this.colorMenu);

    }

    public void associate(EditorArea editorArea) {
        this.editorArea = editorArea;
        this.fileMenu.associate(this.editorArea);
        this.editMenu.associate(this.editorArea);
        this.colorMenu.associate(this.editorArea);
    }

    public void initialize() {
        this.fileMenu.initialize();
        this.editMenu.initialize();

    }

}