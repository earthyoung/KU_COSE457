package models;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class TAnchor implements Serializable  { // 9개의 동그라미가 존재한다

    private static final long serialVersionUID = 1L;

    // 동그라미 사이즈는 고정시키자
    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    public enum EAnchors {
        // 방위의 이름을 지을 것이다. - 따로 따로 알아야지 cursor을 변경시킬 수 있다.
        eNW,
        eWW,
        eSW,
        eSS,
        eSE,
        eEE,
        eNE,
        eNN,

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
    //	public void setResizeAnchor(EAnchors eResizeAnchor) {
//		this.eResizeAnchor=eResizeAnchor;
//	}
    // Constructors
    public TAnchor() {
        // 동그라미를 가르키는 것을 9개 만든 것이다. - Anchor 만들 준비는 다 끝난 것임
        // Anchor가 도형을 싸고 잇는 경우와 도형이 Anchor을 가지고 있는 경우 2가지가 존재
        // -> 모든 도형이 내부에 anchor를 가지고 있고 그려야 할 때 그려야 하자
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


    public void draw(Graphics2D graphics2D, Rectangle boungindRectangle) { // draw(Graphics2D graphics, Shape boungindRectangle)

        graphics2D.setStroke(new BasicStroke((float) 1));

        for(int i=0; i<EAnchors.values().length-1; i++ ) {
            EAnchors eAnchor = EAnchors.values()[i];
            int x= boungindRectangle.x;
            int y= boungindRectangle.y;
            int w = boungindRectangle.width;
            int h = boungindRectangle.height;

            // 정리를 하면 오류발견하는 것도 쉽고, 패턴를 찾을 수 있다.
            // -> 한눈에 정리가 되면 어디서 에러를 잘 안 낼 수 있다.
            // 생성자에 넣는 것이 좋다.
            // if보다 switch가 훨씬 빠르다.
            switch (eAnchor) {
                case eNW:                              break;
                case eWW:                y = y + h/2;  break;
                case eSW:                y = y + h;    break;
                case eSS: x = x + w/2;   y = y + h;    break;
                case eSE: x = x + w;     y = y + h;    break;
                case eEE: x = x + w;     y = y + h/2;  break;
                case eNE: x = x + w;                   break;
                case eNN: x = x + w/2;                 break;
                default:                               break;
            }
            x = x - WIDTH/2;
            y = y - HEIGHT/2;

            this.anchors[eAnchor.ordinal()].setFrame(x,y, WIDTH,HEIGHT);
            // 안에만 하얗게 바운더리는 까맣게
            // -> 배경이 하얗게 되면 안되기 때무네
            // -> 지운다 : 배경을 새로 그리는 것이다.
            //  일반적으로 하얀색으로 칠하면 지워진다고 생각하는데 아니다.

            // 색깔을 고정을 시켜버려서

            Color foreground = graphics2D.getColor(); // 미리 값을 빼 놓은다. - gray

//			graphics2D.setColor(graphics2D.getBackground());
//			graphics2D.fill(this.anchors[eAnchor.ordinal()]); // 안에다가는 백그라운드 색깔을 채운다.

            graphics2D.setColor(Color.WHITE);
            graphics2D.fill(this.anchors[eAnchor.ordinal()]); // 안에다가는 백그라운드 색깔을 채운다.

            graphics2D.setColor(foreground); // foreground 색깔로 변경
            graphics2D.draw(this.anchors[eAnchor.ordinal()]);

            // Background : 배경색
            // Foreground: default 값 (까만색)
        }
    }
    public Point2D getResizeAnchorPoint(int x, int y) {
        this.eResizeAnchor = null;
        switch (this.eSelecetedAnchor) {
            case eNW: eResizeAnchor = EAnchors.eSE; break;
            case eWW: eResizeAnchor = EAnchors.eEE; break;
            case eSW: eResizeAnchor = EAnchors.eNE; break;
            case eSS: eResizeAnchor = EAnchors.eNN; break;
            case eSE: eResizeAnchor = EAnchors.eNW; break;
            case eEE: eResizeAnchor = EAnchors.eWW; break;
            case eNE: eResizeAnchor = EAnchors.eSW; break;
            case eNN: eResizeAnchor = EAnchors.eSS; break;
            default: break;
        }
        // resize 하기위한 좌표를 구한 것임
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
}