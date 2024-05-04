package models;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class TLine extends TShape {

    public TLine() {
        this.shape = new Line2D.Double();
    }

    public TLine(double x, double y, double width, double height) {
        this.observers=new ArrayList<>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = new Message(x,y,width,height);
    }

    @Override
    public void prepareDrawing(int x, int y) {
        Line2D line = (Line2D) this.shape;
        line.setLine(x,y,x,y);
    }

    @Override
    public void keepDrawing(int x, int y) {
        Line2D line = (Line2D) this.shape;
        line.setLine(line.getX1(),line.getY1(),x,y);
    }

}
