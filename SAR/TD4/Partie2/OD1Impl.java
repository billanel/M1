package Partie2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OD1Impl extends UnicastRemoteObject implements OD1I {
    // public class OD1Impl extends UneAutreClasse implements OD1I {
    // si OD1Impl hérite d'une autre classe, elle ne peut pas hériter de
    // UnicastRemoteObject

    private boolean aFaite = false;
    private boolean bFaite = false;
    private boolean cFaite = false;

    public OD1Impl() throws RemoteException {
        super();
    }

    public synchronized void A() throws RemoteException {
        System.out.println("A");
        aFaite = true;
        notifyAll();
    }

    public synchronized void waitA() throws RemoteException {
        while (!aFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void B() throws RemoteException {
        System.out.println("B");
        bFaite = true;
        notifyAll();
    }

    public synchronized void waitB() throws RemoteException {
        while (!bFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void C() throws RemoteException {
        System.out.println("C");
        cFaite = true;
        notifyAll();
    }

    public synchronized void waitC() throws RemoteException {
        while (!cFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}