package main;

import VisualGame.GameScene;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Game {
    Pane pane;
    Client client;
    Application app;
    NameRegistration nameRegistration;
    Comunication comunication;
    Label gameFind;
    GameScene gameScene;

    private void inizializeServer() throws Exception {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost");
            Bridge bridge = (Bridge) reg.lookup(Bridge.NAME);
            client = new Client(bridge);
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error alert");
            alert.setHeaderText("Server Error");
            alert.setContentText("Can't connect to server!");
            alert.show();
            app.stop();
        }
    }

    public Game(Pane pane, Application app) throws Exception {
        this.pane = pane;
        this.app =app;
        inizializeServer();
        gameFind=new Label("main.Game Find");
        gameFind.setLayoutX(250);
        gameFind.setLayoutY(200);
        //nameRegistration = new NameRegistration(pane,client,this);
        //comunication = new Comunication(pane, client,this);
        //pane.getChildren().add(gameFind);
        gameFind.setVisible(false);
        gameScene = new GameScene(50,50,300,300,4,pane);
        gameScene.show();
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Point2D point2D = new Point2D(event.getX(),event.getY());
                gameScene.findClickedPoint(point2D);
            }
        });

    }

    public void showComunication(){
        comunication.show();
    }

    public void showNewOpponentFound(){
        gameFind.setVisible(true);

    }
}
