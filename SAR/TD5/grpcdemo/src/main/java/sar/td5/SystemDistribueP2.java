package sar.td5;

import io.grpc.Server;

public class SystemDistribueP2 {
    public static void main(String[] args) {
        OD2IIpmlBase od2 = new OD2Impl();
        Server serveur = ServerBuilder.forPort(8080).addService(od2).build();
        serveur.start();

        serveur.awaitTermination();

    }
}