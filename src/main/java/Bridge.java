import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Bridge extends Remote {
    final String NAME = "Bridge";

    public int addName(String name) throws RemoteException;

    public boolean isExist(String name) throws RemoteException;

    public ArrayList<String> getNameList() throws RemoteException;

    public void sendMessage(String who_send, String reciver, String value) throws  RemoteException;

    public boolean iHaveMail(String name)throws RemoteException;

    public String getMessage(String name) throws RemoteException;
}
