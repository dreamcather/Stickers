import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
