package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.EditorArea;

public class DrawingAttributeMenu extends JMenu {

    private static final long serialVersionUID = 1L;

    private EditorArea editorArea;

    public DrawingAttributeMenu(String title) {
        super(title);

        ActionHandler actionHandler = new ActionHandler();

        JMenuItem colorMenuItem = new JMenuItem("라인 색");
        colorMenuItem.addActionListener(actionHandler);
        this.add(colorMenuItem);

        JMenuItem lineSize = new JMenuItem("라인 크기");
        lineSize.addActionListener(actionHandler);
        this.add(lineSize);

        JMenuItem fillShape = new JMenuItem("채우기");
        fillShape.addActionListener(actionHandler);
        this.add(fillShape);
    }

    public void associate(EditorArea editorArea) {
        this.editorArea = editorArea;
    }

    public void changeShapeDraw(Color selectedColor) {
        this.editorArea.changeShapeDraw(selectedColor);
    }
    public void changeShapeLineSize(float f) {
        this.editorArea.changeShapeLineSize(f);
    }

    public void changeShapeFill(Color selectedColor) {
        this.editorArea.setShapefillColor(selectedColor);
    }

    private class ActionHandler implements ActionListener {

        JColorChooser chooser = new JColorChooser();

        @Override
        public void actionPerformed(ActionEvent e) {
            if((e.getActionCommand()).equals("라인 색")) {
                @SuppressWarnings("static-access")
                Color selectedColor = chooser.showDialog(null, "Color", Color.YELLOW);
                System.out.println(selectedColor);
                changeShapeDraw(selectedColor);

                if(selectedColor == null) {
                    changeShapeDraw(Color.black);
                }
            }else if((e.getActionCommand()).equals("라인 크기")){
                JOptionPane aa=new JOptionPane();
                @SuppressWarnings("static-access")
                String numbere = aa.showInputDialog("선의 크기를 입력하세요.");

                // 입력값이 ""일때 오류
                if(numbere != null) {
                    float number=Integer.parseInt(numbere);
                    changeShapeLineSize(number);
                }else {
                    System.out.println("입력이 안되었습니다.");
                }

            }else if((e.getActionCommand()).equals("채우기")) {
                @SuppressWarnings("static-access")
                Color selectedColor = chooser.showDialog(null, "Color", Color.YELLOW);
                changeShapeFill(selectedColor);
            }

        }
    }


}