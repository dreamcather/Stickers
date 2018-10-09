package VisualGame;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PointModel implements VisualObject {
    private Circle source;
    private boolean marked;

    public PointModel(int xCoordinate,int yCoordinate, int radius) {
        source = new Circle(xCoordinate,yCoordinate,radius);
        marked = false;
    }
    public Point2D getCenter(){
        return new Point2D(source.getCenterX(),source.getCenterY());
    }

    private double distance(Point2D point)
    {
        return Math.sqrt(Math.pow(point.getX() -source.getCenterX(),2)+Math.pow(point.getY() - source.getCenterY(),2));
    }
    public boolean isNear(Point2D position){
        if(distance(position)<source.getRadius())
            return true;
        else return false;
    }

    @Override
    public void show(Pane anchorPane) {
        anchorPane.getChildren().add(source);
    }

    @Override
    public void hide(Pane anchorPane) {

    }

    @Override
    public void refresh() {
        source.toFront();
    }

    public void active(){
        source.setFill(Color.RED);
    }

    public void disactive(){source.setFill(Color.BLACK);}
}
