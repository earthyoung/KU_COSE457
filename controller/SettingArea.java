package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Observable;
import models.Observer;
import models.TSelection;
import models.TShape;
import java.util.Vector;

public class SettingArea extends JPanel implements Observer{
	
private static final long serialVersionUID = 1L;


	TShape t;
	private Vector<TShape> shapes=new Vector<>();
	
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
   
    private SettingArea() {
 
        this.setLayout(new GridLayout(15,2));
        //this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.add(new JLabel("라인 색:"));
        JButton colorPickerButton = new JButton("색상 선택");
        colorPickerButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "색상 선택", currentColor); // 초기 색상을 검은색으로 설정
            if (selectedColor != null) {
                // 여기에서 선택된 색상을 사용하는 로직을 구현합니다.
            	for(TShape shape:shapes) {
            		if(shape.isSelected()) {
            			commander.setCommand(new SetColorCommand(shape,selectedColor));
                    	commander.runCommand();
            		}
            	}
            }
        });
        this.add(colorPickerButton);
       
        this.add(new JLabel("채우기 색:"));
        JButton fillColorPickerButton = new JButton("색상 선택");
        fillColorPickerButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "색상 선택", fillColor); // 초기 색상을 검은색으로 설정
            if (selectedColor != null) {
                // 여기에서 선택된 색상을 사용하는 로직을 구현합니다.
            	for(TShape shape:shapes) {
            		if(shape.isSelected()) {
            			commander.setCommand(new SetFillColorCommand(shape,selectedColor));
            			commander.runCommand();
            		}
            	}
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
        
        JButton toFront = new JButton("앞으로");
        toFront.addActionListener(e -> {
        	Command temp=new ToFrontCommand(t);
        	commander.setCommand(temp);  			
			commander.runCommand();
        });
        this.add(toFront);
        
        JButton toBack = new JButton("뒤로");
        toBack.addActionListener(e -> {
        	Command temp=new ToBackCommand(t);
        	commander.setCommand(temp);  			
			commander.runCommand();
        });
        this.add(toBack);
        
        JButton toTop = new JButton("맨 앞으로");
        toTop.addActionListener(e -> {
        	Command temp=new ToTopCommand(t);
        	commander.setCommand(temp);  			
			commander.runCommand();
        });
        this.add(toTop);
        
        JButton toBottom = new JButton("맨 뒤로");
        toBottom.addActionListener(e -> {
        	Command temp=new ToBottomCommand(t);
        	commander.setCommand(temp);  			
			commander.runCommand();
        });
        this.add(toBottom);
        
        
        for(int i=0;i<this.getComponents().length;i++) {
			this.getComponent(i).setVisible(false);
		}
    }
    
    
    private void changeX() {
    	for(TShape shape:shapes) {
    		if(shape.isSelected()) {
    			Command temp=new SetXCommand(shape,Integer.parseInt(xCoordField.getText()),t.getCenterX());
    			commander.setCommand(temp);  			
    			commander.runCommand();
    		}
    	}
    }
    
    private void changeY() {
    	for(TShape shape:shapes) {
    		if(shape.isSelected()) {
    			Command temp=new SetYCommand(shape,Integer.parseInt(yCoordField.getText()),t.getCenterY());
    			commander.setCommand(temp);
    			commander.runCommand();
    		}
    	}
    }

    private void changeSize() {
    	for(TShape shape:shapes) {
    		if(shape.isSelected()) {
    			Command temp=new SetSizeCommand(shape,Float.parseFloat(sizeField.getText()));
    			commander.setCommand(temp);
    			commander.runCommand();
    		}
    	}
    }
    
    
	@Override
	public void update(Observable o) {
		if(o==null)return;
		if(o instanceof TSelection) {
			return;
		}
		//TShape가 업데이트 되었을 때 해당 객체의 값을 받아옴
		
		t=(TShape)o;
		
		if(!shapes.contains(t)) {
			shapes.add(t);
		}
		
		//System.out.println(t.getCenterX());
		
		sizeField.setText(""+t.getSize());
		currentColor=t.getShapeColor();
		fillColor=t.getShapefillColor();
		//check.setSelected(t.isSelected());
		
		xCoordField.setText(""+t.getCenterX());
		yCoordField.setText(""+t.getCenterY());
		
		
		if(t.isSelected()==false) {
			
			for(int i=0;i<SettingArea.getInstance().getComponents().length;i++) {
				SettingArea.getInstance().getComponent(i).setVisible(false);
			}
			
		}else {
			for(int i=0;i<SettingArea.getInstance().getComponents().length;i++) {
				SettingArea.getInstance().getComponent(i).setVisible(true);
			}
		}
	}
    

}