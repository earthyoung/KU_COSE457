package models;

import java.util.Observer;

public class Image extends Canvas {

    private String path;

    public Image() {}
    public Image(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Image(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void register(Observer obj) {

    }

    @Override
    public void unregister(Observer obj) {

    }
}
