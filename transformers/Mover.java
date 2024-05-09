package transformers;

import models.TShape;

public class Mover extends Transformer {

    public Mover(TShape tShape) {
        super(tShape);
    }

    @Override
    public void prepare(int x, int y) {
        this.px = x;
        this.py = y;
    }

    @Override
    public void keepTransforming(int x, int y) {
        this.affineTransform.translate(x - this.px, y - this.py);
        this.px = x;
        this.py = y;
    }

    @Override
    public void finalize(int x, int y) {

    }
}
