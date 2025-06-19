package Partie2;

import java.rmi.RemoteException;

public class ProcessusP3 extends Thread {

    private OD1I od1;
    private OD2I od2;
    private OD3I od3;

    public ProcessusP3(OD1I o1, OD2I o2, OD3I o3) {
        this.od1 = o1;
        this.od2 = o2;
        this.od3 = o3;
    }

    public void run() {
        try {
            od1.waitA();
            od1.B();
            od3.waitE();
            od2.waitG();
            od1.C();
            od3.waitF();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}