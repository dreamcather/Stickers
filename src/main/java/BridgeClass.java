import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BridgeClass extends UnicastRemoteObject implements Bridge {

    protected BridgeClass() throws RemoteException {
    }
}
