package transformers;

import models.TShape;

public class Drawer extends Transformer {

    public Drawer(TShape tShape) {
        super(tShape);
    }

    @Override
    public void prepare(int x, int y) {
        this.tShape.prepareDrawing(x, y);
    }

    @Override
    public void keepTransforming(int x, int y) {
        this.tShape.keepDrawing(x, y);
    }

    @Override
    public void finalize(int x, int y) {

    }
}
