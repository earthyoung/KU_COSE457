package controller;

import models.TShape;
import models.Observable;
import models.Observer;
import models.TRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class EditorArea extends JPanel implements Observer {

    private double currentX = 0;
    private double currentY = 0;
    private ArrayList<TShape> shapes = new ArrayList<>();
    private TShape selectedShape;
    private Point prevPoint;
    private boolean drawingState = true;

    private EditorArea() {
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    public void initialize() {

    }

    @Override
    public void update(Observable o) {
        repaint();
    }

    private static class singletonHelper {
        private static final EditorArea INSTANCE = new EditorArea();
    }

    public static EditorArea getInstance() {
        return singletonHelper.INSTANCE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private TShape getShapeAtPoint(Point point) {
        for (TShape shape : shapes) {
            if (shape.isIncluded(point.getX(), point.getY())) {
                return shape;
            }
        }
        return null;
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D)graphics;

        super.paint(graphics2d);

        for (TShape shape : this.shapes) {
            shape.draw(graphics2d);
        }
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            selectedShape = getShapeAtPoint(e.getPoint());
            if (selectedShape == null) {
                double width = Math.abs(e.getX() - currentX);
                double height = Math.abs(e.getY() - currentY);
                selectedShape = new TRectangle(currentX, currentY, width, height);
                shapes.add(selectedShape);
            }
            prevPoint = e.getPoint();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {
            double width = e.getX() - currentX;
            double height = e.getY() - currentY;
            TShape TShape = new TRectangle(currentX, currentY, width, height);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }

}
