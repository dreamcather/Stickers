import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BridgeClass extends UnicastRemoteObject implements Bridge {

    private ArrayList<String> accounts;
    protected BridgeClass() throws RemoteException {
        accounts = new ArrayList<>();
    }

    public int addName(String name) throws RemoteException {
        if(!isExist(name)){
            accounts.add(name);
            return 0;
        }
        return -1;
    }

    public boolean isExist(String name) throws RemoteException {
        if(accounts.indexOf(name)==-1)
            return false;
        return true;
    }
}
