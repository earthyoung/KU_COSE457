package transformers;

import models.TAnchor;
import models.TShape;

import java.awt.geom.AffineTransform;

public abstract class Transformer {

    protected TShape tShape;
    protected AffineTransform affineTransform;
    protected TAnchor tAnchor;
    protected int px, py;

    public Transformer(TShape tShape) {
        this.tShape = tShape;
        this.affineTransform = tShape.getAffineTransform();
        this.tAnchor = tShape.getTAnchor();
    }

    public abstract void prepare(int x, int y);
    public abstract void keepTransforming(int x, int y); // ��ǥ ����
    public abstract void finalize(int x, int y);

}
