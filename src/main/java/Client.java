import java.rmi.RemoteException;

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
}
