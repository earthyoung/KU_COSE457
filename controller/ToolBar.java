package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import models.Constants.EColorMenu;
import models.Constants.ETools;
import java.awt.*;

public class ToolBar extends JToolBar { // ToolBar : 버튼 implements ActionListener
    private static final long serialVersionUID = 1L;

    private EditorArea editorArea;

    private JRadioButton selectedColor;
//	private JTextArea jTextArea;

    public ToolBar() {
        ButtonGroup buttonGroup = new ButtonGroup();
        ActionHandler actionHandler = new ActionHandler(); // 액션리슨너 - 이벤트 핸들러를 버튼에 붙임 // 이벤트 핸들러를 버튼에 직접 붙인다.

        for(ETools eTool: ETools.values()) {
            JRadioButton drawingTool;
            if(eTool == ETools.eSelection) {
                drawingTool = new JRadioButton(eTool.getLabel());
            }else {
                drawingTool = new JRadioButton(eTool.getLabel());
            }

            drawingTool.setActionCommand(eTool.name());  // 글씨를 써놓을 수 있다.  - String이자 variable이다.
            drawingTool.addActionListener(actionHandler);

            drawingTool.setToolTipText(eTool.getToolTip());

            this.add(drawingTool);
            buttonGroup.add(drawingTool);
        }

//		JRadioButton text = new JRadioButton("T");
//		text.addActionListener(actionHandler);
//		this.add(text);
//		buttonGroup.add(text);

//		this.jTextArea = new JTextArea();
//		this.jTextArea.setBounds(50, 50, 300, 300);
//		this.add(this.jTextArea);

    }

    public void associate(EditorArea editorArea) {
        this.editorArea = editorArea;
        JRadioButton defaultButton = (JRadioButton) this.getComponent(ETools.eSelection.ordinal());	// downCasting
        defaultButton.doClick();
    }


    public void initialize() {
        // TODO Auto-generated method stub

    }

    public void changeShapeDraw(Color selectedColor) {
        this.editorArea.changeShapeDraw(selectedColor);
    }

    public void changeButtonColor(ETools eTools) {
        JRadioButton clickedButton = (JRadioButton) this.getComponent(eTools.ordinal());
        clickedButton.setBackground(new Color(204, 204, 204));

//		if(color != null) {
//			JRadioButton button = (JRadioButton) this.selectedColor;
//			button.setBackground(new Color(230, 230, 230));
//		}
        ETools[] arr = ETools.values();
        for(ETools rb : arr) {
            if(rb != eTools) {
                JRadioButton button = (JRadioButton) this.getComponent(rb.ordinal());
                button.setBackground(new Color(230, 230, 230));
            }
        }
    }

    private class ActionHandler implements ActionListener {
        JColorChooser chooser = new JColorChooser();

        @Override
        public void actionPerformed(ActionEvent e) {
            // getSource() : 이벤트를 발생시킨 객체의 위치값을 가져옴
            // getActionCommand() : 이벤트를 발생시킨 객체의 문자열을 가져옴

            if (ETools.valueOf(e.getActionCommand()) != null) {
                changeButtonColor(ETools.valueOf(e.getActionCommand()));
                editorArea.setSelectedTool(ETools.valueOf(e.getActionCommand()));

            }

        }

    }

}