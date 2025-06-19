package sar.td5;

import org.checkerframework.checker.units.qual.g;

import io.grpc.stub.StreamObserver;

public class OD2Impl extends OD2IIpmlBase {

    private boolean gFaite = false;

    public void G(MessageVide msg, StreamObserver<MessageVide> obs) {
        System.out.println("G");
        gFaite = true;
        notifyAll();
    }

    public void waitG(MessageVide msg, StreamObserver<MessageVide> obs) {
        while (!gFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        obs.onNext(msg);
        obs.onCompleted();
    }

}
