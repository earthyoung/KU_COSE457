package models;
import java.util.List;
import java.util.ArrayList;
import java.util.Observer;

public abstract class Canvas implements Subject{
	class Message{
		int x,y,width,height;
		public Message(int x,int y,int width,int height) {
			this.x=x;
			this.y=y;
			this.width=width;
			this.height=height;
		}
	}
	private List<Observer> observers;
	private Message message;
	
	
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Canvas() {}
    public Canvas(int x, int y, int width, int height) {
        this.observers=new ArrayList<>();
    	this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = new Message(x,y,width,height);
    }

    @Override
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
            observer.update(null, message);
//    		observer.update(message.x,message.y,message.width,message.height);
    	}
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setX(int x) {
        this.x = x;
        this.message.x = x;
        notifyObservers();
    }

    public void setY(int y) {
        this.y = y;
        this.message.y = y;
        notifyObservers();
    }

    public void setWidth(int width) {
        this.width = width;
        this.message.width = width;
        notifyObservers();
    }

    public void setHeight(int height) {
        this.height = height;
        this.message.height = height;
        notifyObservers();
    }

}
