package controller;

import models.Observer;
import models.TShape;

public class TImage extends TShape {

    private String path;

    public TImage() {
//
    }

    @Override
    public TShape clone() {
        return null;
    }

//    public TImage(double x, double y, double width, double height) {
//        super(x, y, width, height);
//    }

    @Override
    public void prepareDrawing(int x, int y) {

    }

    @Override
    public void keepDrawing(int x, int y) {

    }

//    public TImage(double x, double y, double width, double height, String path) {
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.path = path;
//    }

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

    @Override
    public void notifyObservers() {

    }
}
