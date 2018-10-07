import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Bridge extends Remote {
    final String NAME = "Bridge";

    public int addName(String name) throws RemoteException;

    public boolean isExist(String name) throws RemoteException;
}
