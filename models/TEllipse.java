package models;


import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class TEllipse extends TShape {

    public TEllipse() {
        this.shape = new Ellipse2D.Double();
    }

    @Override
    public TShape clone() {
        return new TEllipse();
    }

//    public TEllipse(double x, double y, double width, double height) {
//        this.observers=new ArrayList<>();
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.message = new Message(x,y,width,height);
//    }

    @Override
    public void prepareDrawing(int x, int y) {
        Ellipse2D ellipse = (Ellipse2D) this.shape;
        ellipse.setFrame(x, y, 0, 0);
    }

    @Override
    public void keepDrawing(int x, int y) {
        Ellipse2D ellipse = (Ellipse2D) this.shape;
        ellipse.setFrame(ellipse.getX(), ellipse.getY(), x - ellipse.getX(), y - ellipse.getY());
    }

}
