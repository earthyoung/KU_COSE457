package models;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class TLine extends TShape {

    public TLine() {
        this.shape = new Line2D.Double();
    }

    @Override
    public TShape clone() {
        return new TLine();
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
