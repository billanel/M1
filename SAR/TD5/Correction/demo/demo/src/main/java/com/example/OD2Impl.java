package com.example;

import CodeGrpcGenere.MessageVide;
import CodeGrpcGenere.OD2IGrpc.OD2ImplBase;
import io.grpc.stub.StreamObserver;

public class OD2Impl extends OD2IImplBase {
    private boolean gDone = false;

    public synchronized  void g(MessageVide msg, StreamObserver<MessageVide> obs) {
        System.out.println("G");
        gDone = true;
        notifyAll();
    }

    public synchronized void waitG(MessageVide msg, StreamObserver<MessageVide> obs) {
        while(!gDone) {
            try { wait() ;}
            catch (Exception e) {}
        }
        obs.onNext(msg);
        obs.onCompleted();
    }
}
