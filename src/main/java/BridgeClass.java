import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BridgeClass extends UnicastRemoteObject implements Bridge {

    private ArrayList<String> accounts;
    private ArrayList<MessageMail> mails;

    private MessageMail find(String name){
        for(int i=0;i<mails.size();i++){
            if(mails.get(i).getName().equals(name))
                return mails.get(i);
        }
        return null;
    }

    protected BridgeClass() throws RemoteException {
        accounts = new ArrayList<>();
        mails = new ArrayList<>();
    }

    public int addName(String name) throws RemoteException {
        if(!isExist(name)){
            accounts.add(name);
            mails.add(new MessageMail(name));
            return 0;
        }
        return -1;
    }

    public boolean isExist(String name) throws RemoteException {
        if(accounts.indexOf(name)==-1)
            return false;
        return true;
    }

    public ArrayList<String> getNameList() throws RemoteException {
        return accounts;
    }

    public void sendMessage(String who_send, String reciver, String value) throws RemoteException {

        MessageMail messageMail = find(reciver);
        messageMail.addMessage(who_send+":"+value);

    }

    public boolean iHaveMail(String name) throws RemoteException {
        MessageMail messageMail = find(name);
        return  !messageMail.isEmpty();
    }

    @Override
    public String getMessage(String name) throws RemoteException {
        MessageMail messageMail = find(name);
        return messageMail.getMessage();
    }
}
