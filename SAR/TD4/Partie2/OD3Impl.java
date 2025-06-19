package Partie2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OD3Impl extends UnicastRemoteObject implements OD3I {

    private boolean eFaite = false;
    private boolean fFaite = false;

    public OD3Impl() throws RemoteException {
        super();
    }

    public synchronized void E() throws RemoteException {
        System.out.println("E");
        eFaite = true;
        notifyAll();
    }

    public synchronized void waitE() throws RemoteException {
        while (!eFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void F() throws RemoteException {
        System.out.println("F");
        fFaite = true;
        notifyAll();
    }

    public synchronized void waitF() throws RemoteException {
        while (!fFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}