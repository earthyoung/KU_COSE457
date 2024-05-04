package models;

import java.awt.*;
import java.util.ArrayList;


public class TRectangle extends TShape {

    public TRectangle() {
        this.shape = new Rectangle();
    }

    public TRectangle(double x, double y, double width, double height) {
        this.observers=new ArrayList<>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = new Message(x,y,width,height);
    }

    @Override
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
