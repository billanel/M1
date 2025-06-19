package sar.td5;

import java.rmi.RemoteException;
import java.util.stream.Stream;

import com.google.protobuf.Message;

public class ProcessusP2 {

    private OD1IBlockingStub od1;
    private OD3IBlockingStub od3;
    private OD2IImplBase od2;

    private MessageVide vide;
    private StreamObserver<MessageVide> response;

    public ProcessusP2(OD1IBlockingStub o1, OD2IImplBase o2, OD3IBlockingStub o3) {
        this.od1 = o1;
        this.od2 = o2;
        this.od3 = o3;
        vide = MessageVide.newBuilder().build();

    }

    public void go() {
        try {
            od1.A();
            od1.waitB();
            od3.E();
            od2.waitG();
            od1.waitC();
            od3.F();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
