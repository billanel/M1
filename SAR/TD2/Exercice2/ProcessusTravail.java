import java.io.IOException;

public class ProcessusTravail {

    SyncSocket CA;
    SyncSocket CT;

    public ProcessusTravail(SyncSocket ca, SyncSocket ct) {
        this.CA = ca;
        this.CT = ct;
    }

    public void calculTau() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            System.out.println("Etat 0");
            CT.receive("autorisation");
            System.out.println("Etat 1");
            CT.receive("code");
            System.out.println("Etat 2");
            CA.receive("code");
            System.out.println("Etat 3");
            CA.receive("demandePlages");
            System.out.println("Etat 4");
            calculTau();
            System.out.println("Etat 5");
            CA.send("plagesLibres");
            System.out.println("Etat 6");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
