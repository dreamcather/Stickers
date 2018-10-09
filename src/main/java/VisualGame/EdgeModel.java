package VisualGame;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class EdgeModel implements VisualObject {
    private Line source;
    private Color color;

    public EdgeModel(Point2D start, Point2D end, double width ) {
        source = new Line(start.getX(),start.getY(),end.getX(),end.getY());
        source.setStrokeWidth(width);
        source.setStroke(Color.BLACK);
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
    }
}
