package transformers;

import models.TAnchor;
import models.TShape;

import java.awt.geom.Point2D;


public class Resizer extends Transformer {

    private double xScale, yScale;
    private double cx, cy;

    public Resizer(TShape tShape) {
        super(tShape);
    }

    @Override
    public void prepare(int x, int y) {
        this.px = x;
        this.py = y;
        Point2D resizeAnchorPoint = this.tAnchor.getResizeAnchorPoint(x, y);
        this.cx = resizeAnchorPoint.getX();
        this.cy = resizeAnchorPoint.getY();
    }

    @Override
    public void keepTransforming(int x, int y) {
        this.getResizeScale(x, y);

        this.affineTransform.translate(cx, cy);
        this.affineTransform.scale(this.xScale, this.yScale); // ��ŭ ���������� �����ش�
        this.affineTransform.translate(-cx, -cy);

        this.px = x;
        this.py = y;
    }





    @Override
    public void finalize(int x, int y) {

    }

    protected void getResizeScale(int x, int y) {
        TAnchor.EAnchors eResizeAnchor = this.tAnchor.getResizeAnchor();
        double w1 = px - cx; // ���� ������ width
        double w2 = x - cx;  // �ٲ�

        double h1 = py - cy;
        double h2 = y - cy;

        switch (eResizeAnchor) {
            case eNW: xScale = w2/w1;  yScale= h2/h1;  break;
            case eWW: xScale = w2/w1; yScale= 1;      break;
            case eSW: xScale = w2/w1;  yScale= h2/h1; break;
            case eSS: xScale = 1;      yScale= h2/h1; break;
            case eSE: xScale = w2/w1;  yScale= h2/h1;  break;
            case eEE: xScale = w2/w1;  yScale= 1;      break;
            case eNE: xScale = w2/w1; yScale= h2/h1;  break;
            case eNN: xScale = 1;      yScale= h2/h1;  break;
            default:  break;
        }
    }

}
