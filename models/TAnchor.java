package models;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class TAnchor implements Serializable  { // 9���� ���׶�̰� �����Ѵ�

    private static final long serialVersionUID = 1L;

    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    public enum EAnchors {
        eNW,
        eWW,
        eSW,
        eSS,
        eSE,
        eEE,
        eNE,
        eNN,
        eRR,

        eMove
    }
    private Ellipse2D anchors[];
    private EAnchors eSelecetedAnchor;
    private EAnchors eResizeAnchor;

    public EAnchors getSelecetedAnchor() {
        return this.eSelecetedAnchor;
    }
    public void setSelectedAnchor(EAnchors eSelecetedAnchor) {
        this.eSelecetedAnchor=eSelecetedAnchor;
    }
    public EAnchors getResizeAnchor() {
        return this.eResizeAnchor;
    }

    // Constructors
    public TAnchor() {
        this.anchors = new Ellipse2D[EAnchors.values().length-1];
        for(int i=0; i<EAnchors.values().length-1; i++ ) {
            this.anchors[i] = new Ellipse2D.Double();
        }
    }

    // methods
    public boolean contains(int x, int y) {
        for(int i=0; i<EAnchors.values().length-1; i++ ) {
            if( this.anchors[i].contains(x, y) ) {
                this.eSelecetedAnchor = EAnchors.values()[i];
                return true;
            }
        }
        return false;
    }


    public void draw(Graphics2D graphics2D, Rectangle boungindRectangle) {

        graphics2D.setStroke(new BasicStroke((float) 1));

        for(int i=0; i<EAnchors.values().length-1; i++ ) {
            EAnchors eAnchor = EAnchors.values()[i];
            int x= boungindRectangle.x;
            int y= boungindRectangle.y;
            int w = boungindRectangle.width;
            int h = boungindRectangle.height;

            // ������ �ϸ� �����߰��ϴ� �͵� ����, ���ϸ� ã�� �� �ִ�.
            // -> �Ѵ��� ������ �Ǹ� ��� ������ �� �� �� �� �ִ�.
            // �����ڿ� �ִ� ���� ����.
            // if���� switch�� �ξ� ������.
            switch (eAnchor) {
                case eNW:                              break;
                case eWW:                y = y + h/2;  break;
                case eSW:                y = y + h;    break;
                case eSS: x = x + w/2;   y = y + h;    break;
                case eSE: x = x + w;     y = y + h;    break;
                case eEE: x = x + w;     y = y + h/2;  break;
                case eNE: x = x + w;                   break;
                case eNN: x = x + w/2;                 break;
                case eRR: x = x + w/2;   y = y - h/2;  break;
                default:                               break;
            }
            x = x - WIDTH/2;
            y = y - HEIGHT/2;

            this.anchors[eAnchor.ordinal()].setFrame(x,y, WIDTH,HEIGHT);

            Color foreground = graphics2D.getColor();

//			graphics2D.setColor(graphics2D.getBackground());
//			graphics2D.fill(this.anchors[eAnchor.ordinal()]);

            graphics2D.setColor(Color.WHITE);
            graphics2D.fill(this.anchors[eAnchor.ordinal()]);

            graphics2D.setColor(foreground);
            graphics2D.draw(this.anchors[eAnchor.ordinal()]);

        }
    }
    public Point2D getResizeAnchorPoint(int x, int y) {
        this.eResizeAnchor = null;
        switch (this.eSelecetedAnchor) {
            case eNW -> eResizeAnchor = EAnchors.eSE;
            case eWW -> eResizeAnchor = EAnchors.eEE;
            case eSW -> eResizeAnchor = EAnchors.eNE;
            case eSS -> eResizeAnchor = EAnchors.eNN;
            case eSE -> eResizeAnchor = EAnchors.eNW;
            case eEE -> eResizeAnchor = EAnchors.eWW;
            case eNE -> eResizeAnchor = EAnchors.eSW;
            case eNN -> eResizeAnchor = EAnchors.eSS;
            default -> {
            }
        }
        // resize �ϱ����� ��ǥ�� ���� ����
        double cx = this.anchors[eResizeAnchor.ordinal()].getCenterX();
        double cy = this.anchors[eResizeAnchor.ordinal()].getCenterY();
        return new Point2D.Double(cx, cy);
    }

    private int width, height;
    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width;}

    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}

    public Point2D getRotateAnchorPoint() {
        double x1 = this.anchors[EAnchors.eNW.ordinal()].getCenterX();
        double y1 = this.anchors[EAnchors.eNW.ordinal()].getCenterY();

        double x2 = this.anchors[EAnchors.eNE.ordinal()].getCenterX();
        double y2 = this.anchors[EAnchors.eNE.ordinal()].getCenterY();

        double x3 = this.anchors[EAnchors.eSW.ordinal()].getCenterX();
        double y3 = this.anchors[EAnchors.eSW.ordinal()].getCenterY();

        this.width = (int) (x2 - x1);
        this.height = (int) (y3 - y1);

        return new Point2D.Double(x1, y1);
    }
    public void setRotateAnchorPoint() {


    }
}
