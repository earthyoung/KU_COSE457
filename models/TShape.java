package models;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.ArrayList;

public abstract class TShape implements Observable {
	class Message{
		double x,y,width,height;
		public Message(double x,double y,double width,double height) {
			this.x=x;
			this.y=y;
			this.width=width;
			this.height=height;
		}
	}
	protected List<Observer> observers;
	protected Message message;
	
    protected double x = 0;
    protected double y = 0;
    protected double z = 0;
    protected double width = 0;
    protected double height = 0;
    protected Shape shape;
    private TShape tShape;
    private AffineTransform affineTransform;
    private TAnchor tAnchor;

    public TShape() {}
    public TShape(double x, double y, double width, double height) {
        this.observers=new ArrayList<>();
    	this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = new Message(x,y,width,height);
    }

    public void register(Observer obj) {
    	if(!observers.contains(obj))observers.add(obj);
    }

    @Override
    public void unregister(Observer obj){
    	observers.remove(obj);
    }
    
    @Override
    public void notifyObservers() {
    	for(Observer observer:observers) {
    		observer.update(this);
    	}
    }

    public AffineTransform getAffineTransform() {
        return this.affineTransform;
    }

    public TAnchor getTAnchor() {
        return this.tAnchor;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setX(double x) {
        this.x = x;
        this.message.x = x;
        notifyObservers();
    }

    public void setY(double y) {
        this.y = y;
        this.message.y = y;
        notifyObservers();
    }

    public void setWidth(double width) {
        this.width = width;
        this.message.width = width;
        notifyObservers();
    }

    public void setHeight(double height) {
        this.height = height;
        this.message.height = height;
        notifyObservers();
    }

    public void move(double xAmount, double yAmount) {
        this.x += xAmount;
        this.y += yAmount;
        notifyObservers();
    }

    public boolean isIncluded(double xPos, double yPos) {
        if(xPos > this.x + this.width || xPos < this.x) {
            return false;
        } else return yPos <= this.y + this.height && yPos >= this.y;
    }

    public void draw(Graphics2D graphics2d) {
        Color temp = graphics2d.getColor();
        graphics2d.draw(this.shape);
        graphics2d.setStroke(new BasicStroke(1));
    }

    public abstract void prepareDrawing(int x, int y);

    public abstract void keepDrawing(int x, int y);

}
