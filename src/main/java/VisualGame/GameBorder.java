package VisualGame;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GameBorder implements VisualObject {
    private  ArrayList<Rectangle> borderList;

    public GameBorder(int xStart,int yStart,int width,int height, int borderWidth) {
        borderList = new ArrayList<>();
        borderList.add(new Rectangle(xStart,yStart,width+borderWidth,borderWidth));
        borderList.add(new Rectangle(xStart,yStart,borderWidth,height+borderWidth));
        borderList.add(new Rectangle(xStart,yStart+width,width+borderWidth,borderWidth));
        borderList.add(new Rectangle(xStart+height,yStart,borderWidth,height+borderWidth));
    }

    @Override
    public void show(Pane anchorPane) {
        for(int i=0;i<borderList.size();i++){
            anchorPane.getChildren().add(borderList.get(i));
        }

    }

    @Override
    public void hide(Pane anchorPane) {

    }

    @Override
    public void refresh() {

    }
}
