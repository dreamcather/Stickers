package VisualGame;

import javafx.scene.layout.Pane;

public interface VisualObject {
    void show(Pane anchorPane);
    void hide(Pane anchorPane);
    void  refresh();
}
