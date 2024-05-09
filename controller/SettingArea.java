package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Observable;
import models.Observer;
import models.TShape;

public class SettingArea extends JPanel implements Observer{
	
private static final long serialVersionUID = 1L;


	TShape t;
	public CanvasInvoker commander=new CanvasInvoker();

	private static SettingArea instance;

	public static SettingArea getInstance() {
		if (instance == null) {
			instance = new SettingArea();
		}
		return instance;
	}

    private JTextField sizeField;
    private JTextField xCoordField;
    private JTextField yCoordField;
    private Color currentColor;
    private Color fillColor;
    private JCheckBox check;
   
    private SettingArea() {
 
        this.setLayout(new GridLayout(15,2));
        //this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.add(new JLabel("라인 색:"));
        JButton colorPickerButton = new JButton("색상 선택");
        colorPickerButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "색상 선택", currentColor); // 초기 색상을 검은색으로 설정
            if (selectedColor != null) {
                // 여기에서 선택된 색상을 사용하는 로직을 구현합니다.
            	commander.setCommand(new SetColorCommand(t,selectedColor));
            	commander.runCommand();
            }
        });
        this.add(colorPickerButton);
       
        this.add(new JLabel("채우기 색:"));
        JButton fillColorPickerButton = new JButton("색상 선택");
        fillColorPickerButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "색상 선택", currentColor); // 초기 색상을 검은색으로 설정
            if (selectedColor != null) {
                // 여기에서 선택된 색상을 사용하는 로직을 구현합니다.
            	commander.setCommand(new SetFillColorCommand(t,selectedColor));
            	commander.runCommand();
            }
        });
        this.add(fillColorPickerButton);
        
        
        this.add(new JLabel("선 굵기:"));
        sizeField = new JTextField("1");
        sizeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSize();
            }
        });
        this.add(sizeField);
        
        this.add(new JLabel("x:"));
        xCoordField = new JTextField("0");
        xCoordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeX();
            }
        });
        this.add(xCoordField);
        

        this.add(new JLabel("y:"));
        yCoordField = new JTextField("0");
        yCoordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeY();
            }
        });
        this.add(yCoordField);
        
        check= new JCheckBox("선택",true);
        check.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	t.setSelected(check.isSelected());
        	}
        });
        this.add(check);
    }
    
    private void changeX() {
    	commander.setCommand(new SetXCommand(t,xCoordField));
    	commander.runCommand();
    }
    private void changeY() {
    	commander.setCommand(new SetYCommand(t,yCoordField));
    	commander.runCommand();
    }

    private void changeSize() {
    	commander.setCommand(new SetSizeCommand(t,sizeField));
    	commander.runCommand();
    }
    
	@Override
	public void update(Observable o) {
		if(o==null)return;
		//TShape가 업데이트 되었을 때 해당 객체의 값을 받아옴
		t=(TShape)o;
		//System.out.println(t.getCenterX());
		
		sizeField.setText(""+t.getSize());
		currentColor=t.getShapeColor();
		check.setSelected(t.isSelected());
		
		xCoordField.setText(""+t.getCenterX());
		yCoordField.setText(""+t.getCenterY());
		
	}
    

}