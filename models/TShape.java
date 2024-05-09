package models;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.io.Serializable;
import java.awt.geom.AffineTransform;

import models.TAnchor.EAnchors;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.List;

import controller.EditorArea;
import controller.SettingArea;

import java.util.ArrayList;
abstract public class TShape implements Serializable, Cloneable, Observable {
	
	private List<Observer> TShapeList=new ArrayList<>();
	
	
    // attributes
    private static final long serialVersionUID = 1L;

    // graphics Attribute
    private boolean bSelected;  // 현재 도형의 상태
    private Color shapeColor;
    private float size;
    private Color shapefillColor = null;

    // Components: 부품들, /코/입 과 같이 내가 가진 것들
    protected Shape shape; // 점의 집합으로 그림을 그리는 JDK에서 만들어 넣는 2차원 그림을 그릴 수 있는 일반적인 형태
    private AffineTransform affineTransform;
    private TAnchor anchors;

    // setters and getters : 속성을 단순 변경하거나 읽는 것들, 직접 노출하지 않고 사용
    public boolean isSelected() {
        return this.bSelected;
    }
    public void setSelected(boolean bSelected) {
        this.bSelected = bSelected;
        //System.out.println(this.affineTransform.toString());
        notifyObservers();
        EditorArea.getInstance().repaint();
    }
    public EAnchors getSelectedAnchor() {return this.anchors.getSelecetedAnchor();}

    public Color getShapeColor() {
        return shapeColor;
    }
    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
        notifyObservers();
        EditorArea.getInstance().repaint();
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
        notifyObservers();
        EditorArea.getInstance().repaint();
    }
    public Color getShapefillColor() {
        return shapefillColor;
    }
    public void setShapefillColor(Color shapefillColor) {
        this.shapefillColor = shapefillColor;
        notifyObservers();
        EditorArea.getInstance().repaint();
    }
    public int getCenterX() {
        return (int) this.shape.getBounds2D().getCenterX();
    }
    public int getCenterY() {
        return (int) this.shape.getBounds2D().getCenterY();
    }

    public void setNewCenter(int x,int y) {
    	System.out.println(x+","+y);
    	this.affineTransform.setToIdentity();
    	this.affineTransform.translate(x-getCenterX() , y-getCenterY());
    	this.shape = this.affineTransform.createTransformedShape(this.shape);
        this.affineTransform.setToIdentity(); // 초기화
        EditorArea.getInstance().repaint();
    }
    
    // transformer가 사용하기 위해서
    public AffineTransform getAffineTransform() {
        return affineTransform;
    }
    public TAnchor getAnchor() {
        return anchors;
    }

    // 생성자 : 나를 생성하거나 없앰
    public TShape() {
        this.affineTransform = new AffineTransform();
        this.affineTransform.setToIdentity();

        this.anchors = new TAnchor();
        this.bSelected = false;
        this.register(SettingArea.getInstance());
    }
    public abstract TShape clone();
    public void initailize() {};

    public TShape deepClone() throws CloneNotSupportedException {
        TShape copy = (TShape) super.clone();
        this.affineTransform = (AffineTransform) this.affineTransform.clone();

        return copy;
    }

    // method : 실제 객체가 수행하는
    public boolean contains(int x, int y) {
        Shape transformedShape = this.affineTransform.createTransformedShape(this.shape);
        if(isSelected()) {
            if( this.anchors.contains(x, y)) {
                return true;
            }
        }

        if(transformedShape.contains(x, y)) {  // Anchor가 null일 때
            this.anchors.setSelectedAnchor(EAnchors.eMove);
            return true;
        }
        return false;
    }

    public boolean intersects(double x1, double y1, double x2, double y2) {
        double maxX = max(x1, x2);
        double minX = min(x1, x2);
        double maxY = max(y1, y2);
        double minY = min(y1, y2);
        double w = maxX - minX;
        double h = maxY - minY;
        Shape transformedShape = this.affineTransform.createTransformedShape(this.shape);
        return transformedShape.intersects(minX, minY, w, h);
    }

    // draw
    public void draw(Graphics2D graphics2D) {// graphics2D : 그림그리는 좌표를 가지고 있음
        Shape transformedShape = this.affineTransform.createTransformedShape(this.shape);
        graphics2D.setColor(this.getShapeColor());
        graphics2D.setStroke(new BasicStroke((float) this.getSize()));

        if(this.getShapefillColor() != null) {
            graphics2D.setColor(this.getShapefillColor());
            graphics2D.fill(transformedShape);
        }else {
            graphics2D.draw(transformedShape);
        }

        if(isSelected()) {
            graphics2D.setColor(Color.black);
            this.anchors.draw(graphics2D, transformedShape.getBounds());
        }
    }

    public abstract void prepareDrawing(int x, int y);
    public abstract void keepDrawing(int x, int y);
    public void addPoint(int x, int y) {}

    public void finalize(int x, int y) {
        this.shape = this.affineTransform.createTransformedShape(this.shape);
        this.affineTransform.setToIdentity(); // 초기화
        notifyObservers();
        //System.out.println(this.shape.getBounds2D().getMaxX()+","+this.shape.getBounds2D().getMaxY());
    }
    
    
    @Override
    public void register(Observer obj) {
    	if(!TShapeList.contains(obj))TShapeList.add(obj);
    }
    
    @Override
    public void unregister(Observer obj){
    	TShapeList.remove(obj);
    }
    
    @Override
    public void notifyObservers() {
    	if(TShapeList!=null)
    	for(Observer observer:TShapeList) {
    		observer.update(this);
    	}
    }

}