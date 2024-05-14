package controller;

import models.TShape;

import java.awt.*;

public class TSelection extends TShape {

    public TSelection() {
        this.shape = new Rectangle();
    }

    @Override
    public TShape clone() {  // ���ο� ���� ����°��� �ƴ϶�, �ڽ��� ���� ��� ���� ����
        return new TSelection();
    }

    public void prepareDrawing(int x, int y) {
        Rectangle rectangle = (Rectangle) this.shape;
        rectangle.setBounds(x,y,0,0);
    }

    @Override
    public void keepDrawing(int x, int y) {
        Rectangle rectangle = (Rectangle) this.shape;
        rectangle.setSize(x-rectangle.x,y-rectangle.y);
    }

    
}
