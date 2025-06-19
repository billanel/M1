package com.example;

import io.grpc.stub.StreamObserver;

public class ProcessusP2 {
    private OD1IBlockingStub od1;
    private OD3BlockingStub od3;
    private OD2ImplBase od2;

    private MessageVide vide;
    private StreamObserver<MessageVide> reponse;

    public ProcessusP2(OD1IBlockingStub o1, OD2ImplBase o2, OD3BlockingStub o3) {
        this.od1 = o1; this.od2 = o2; this.od3 = o3;
        vide = MessageVide.newBuilder().build();
        reponse = new StreamObserver<MessageVide>() {
            @Override
            public void onNext(MessageVide value) { }

            @Override
            public void onError(Throwable t) { }

            @Override
            public void onCompleted() { }
        }
    }
    
    public void go() {
        od1.a(vide);
        od1.waitB(vide);
        od3.e(vide);
        od2.waitG(vide, reponse);
        od1.waitC(vide);
        od3.f(vide);
    }
}
