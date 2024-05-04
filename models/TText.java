package models;

public class TText extends TShape {

    private String string;

    public TText() {
//        this.shape = new TextField();
    }
    public TText(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void prepareDrawing(int x, int y) {

    }

    @Override
    public void keepDrawing(int x, int y) {

    }

    public TText(double x, double y, double width, double height, String string) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
