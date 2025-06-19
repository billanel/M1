package Partie2;

import java.rmi.RemoteException;

public class OD2Impl implements OD2I {

    private boolean gFaite = false;

    public synchronized void G() throws RemoteException {
        System.out.println("G");
        gFaite = true;
        notifyAll();
    }

    public synchronized void waitG() throws RemoteException {
        while (!gFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}