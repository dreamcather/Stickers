import javafx.scene.control.TextArea;

public class MessageLoop extends Thread {
    Client client;
    TextArea textArea;

    public MessageLoop(Client client, TextArea textArea) {
        this.client = client;
        this.textArea = textArea;
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
        }
    }
}
