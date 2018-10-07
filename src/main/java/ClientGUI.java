import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientGUI extends Application {
    private Client client;
    private Stage window;
    private Scene scene;

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
            alert.showAndWait();
            this.stop();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        inizializeServer();
        window = primaryStage;
        window.setTitle("Game");
        Pane layout = new Pane();
        scene = new Scene(layout, 750, 600);
        window.setScene(scene);
        window.show();
        NameRegistration nameRegistration= new NameRegistration(layout,client);
    }

    public static void main(String[] args){
        launch(args);
    }
}
