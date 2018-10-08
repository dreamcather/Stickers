
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Comunication extends Thread {
    Pane pane;
    TextArea messageBox;
    TextArea messageRider;
    ComboBox <String> comboBox;
    Client client;
    String curentReciver =null;
    MessageLoop messageLoop = null;

    public Comunication(Pane pane, Client client) {
        this.pane = pane;
        this.client = client;
        messageBox = new TextArea();
        messageRider = new TextArea();
        messageBox.setLayoutX(100);
        messageBox.setLayoutY(300);
        comboBox = new ComboBox<>();
        comboBox.setLayoutX(100);
        comboBox.setLayoutY(270);
        messageRider.setLayoutX(100);
        messageRider.setLayoutY(490);
        messageRider.setMaxHeight(10);
        comboBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ArrayList<String> res = client.getNameList();
                ObservableList<String> names = FXCollections.observableArrayList(res);
                comboBox.setItems(names);
            }
        });
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                curentReciver =comboBox.getValue();
            }
        });
        messageBox.setEditable(false);
        messageRider.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.ENTER){
                    String text = messageRider.getText();
                    messageBox.setText(messageBox.getText()+"\n"
                    +client.name+":"+text);
                    messageRider.setText("");
                    if(curentReciver!=null){
                        client.send(curentReciver,text);
                    }
                }
            }
        });
    }

    public void show(){
        pane.getChildren().add(messageBox);
        ArrayList<String> res = client.getNameList();
        ObservableList<String> names = FXCollections.observableArrayList(res);
        comboBox.setItems(names);
        pane.getChildren().add(comboBox);
        pane.getChildren().add(messageRider);
        messageLoop = new MessageLoop(client,messageBox);
        messageLoop.start();

    }
}
