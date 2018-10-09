package main;

import javafx.scene.control.TextArea;

public class MessageLoop extends Thread {
    Client client;
    TextArea textArea;
    Game game;

    public MessageLoop(Client client,Game game, TextArea textArea) {
        this.client = client;
        this.textArea = textArea;
        setDaemon(true);
        this.game = game;
    }

    public void run(){
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(client.iHaveMail()){
                String res = client.getMail();
                if(res!=null){
                    textArea.setText(textArea.getText()+"\n"+res);
                }
            }
            if(client.iHaveGame()){
                game.showNewOpponentFound();
            }
        }
    }
}
