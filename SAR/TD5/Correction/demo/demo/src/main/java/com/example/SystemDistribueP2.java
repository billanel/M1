package com.example;

import java.io.IOException;

import CodeGrpcGenere.OD2IGrpc.OD2IImplBase;
import io.grpc.*;


public class SystemDistribueP2 {
    public static void main(String[] args) throws Exception {
        OD2IImplBase od2 = new OD2Impl();
        Server serveur = ServerBuilder.forPort(1099).addService(od2).build();
        serveur.start();
        ManagedChannel c1 = ManagedChannelBuilder.forAdrdress("192.168.1.13", 1099);
        ManagedChannel c2 = ManagedChannelBuilder.forAdrdress("192.168.0.15", 1099);

        od1 = OD1IGrpc.newBlockingStub(c1);
        od3 = OD3IGrpc.newBlockingStub(c2);

        (new ProcessusP2(od1, od2, od3)).go();
        serveur.awaitTermination();
    }
}