package Partie2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OD1I extends Remote {

    public void A() throws RemoteException;

    public void B() throws RemoteException;

    public void C() throws RemoteException;

    public void waitA() throws RemoteException;

    public void waitB() throws RemoteException;

    public void waitC() throws RemoteException;
}
