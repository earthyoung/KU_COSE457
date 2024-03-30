package models;

public class Text extends Canvas {

    private String string;

    public Text() {}
    public Text(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Text(int x, int y, int width, int height, String string) {
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
