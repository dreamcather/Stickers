import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Game {
    Pane pane;
    Client client;
    Application app;
    NameRegistration nameRegistration;
    Comunication comunication;

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
        nameRegistration = new NameRegistration(pane,client,this);
        comunication = new Comunication(pane, client);
    }

    public void showComunication(){
        comunication.show();
    }
}
