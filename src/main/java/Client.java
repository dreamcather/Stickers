import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {
    String name;
    Bridge bridge;

    public Client(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean isExist(String name){
        try {
            return  bridge.isExist(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addName(String name){
        this.name =name;
        try {
            bridge.addName(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getNameList(){
        ArrayList<String> res =new ArrayList<>();
        try {
            res=bridge.getNameList();
            res.remove(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void send(String name,String value){
        try {
            bridge.sendMessage(this.name,name,value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean iHaveMail(){
        try {
            return bridge.iHaveMail(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getMail(){
        try {
            return bridge.getMessage(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
