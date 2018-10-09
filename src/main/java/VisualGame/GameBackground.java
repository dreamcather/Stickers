package VisualGame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameBackground implements VisualObject{
    private Rectangle source;

    public GameBackground(int xStart, int yStart, int widht, int height) {
        source = new Rectangle(xStart,yStart,widht,height);
        source.setFill(Color.YELLOW);
    }

    @Override
    public void show(Pane anchorPane) {
        anchorPane.getChildren().add(source);
    }

    @Override
    public void hide(Pane anchorPane) {
        anchorPane.getChildren().remove(source);
    }

    @Override
    public void refresh() {

    }
}
