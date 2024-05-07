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

	private static SettingArea instance;

	public static SettingArea getInstance() {
		if (instance == null) {
			instance = new SettingArea();
		}
		return instance;
	}

    private JTextField sizeField;
    private Color currentColor;
    private JCheckBox check;
   
    private SettingArea() {
 
        this.setLayout(new GridLayout(15,2));
        //this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.add(new JLabel("색:"));
        JButton colorPickerButton = new JButton("색상 선택");
        colorPickerButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "색상 선택", currentColor); // 초기 색상을 검은색으로 설정
            if (selectedColor != null) {
                // 여기에서 선택된 색상을 사용하는 로직을 구현합니다.
            	
            }
        });
        this.add(colorPickerButton);
       
        this.add(new JLabel("크기:"));
        sizeField = new JTextField("100");
        sizeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSize();
            }
        });
        this.add(sizeField);
        
        check= new JCheckBox("선택",true);
        this.add(check);
    }

    private void changeColor() {
       
    }

    private void changeSize() {
       
    }
    
	@Override
	public void update(Observable o) {
		if(o==null)return;
		//TShape가 업데이트 되었을 때 해당 객체의 값을 받아옴
		TShape t=(TShape)o;
		
		sizeField.setText(""+t.getSize());
		currentColor=t.getShapeColor();
		check.setSelected(t.isSelected());
	}
    

}