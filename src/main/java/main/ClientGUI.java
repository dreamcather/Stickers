package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClientGUI extends Application {
    private Client client;
    private Stage window;
    private Scene scene;
    private Pane layout;
    NameRegistration nameRegistration;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Game");
        layout = new Pane();
        scene = new Scene(layout, 750, 600);
        window.setScene(scene);
        window.show();
        Game game = new Game(layout,this);

    }
    public void stop(){
        System.out.println("i'm here");
        window.close();
    }

    public static void main(String[] args){
        launch(args);

    }
}
