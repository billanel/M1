import java.io.IOException;

public class ProcessusHopital {

    SyncSocket CH;
    SyncSocket CA;

    public ProcessusHopital(SyncSocket ch, SyncSocket ca) {
        this.CH = ch;
        this.CA = ca;
    }

    public int randomPlace(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public void start() {
        try {
            System.err.println("Etat 0");
            CH.receive("demandeRdzVs");
            System.err.println("Etat 1");
            CH.send("code");
            System.err.println("Etat 2");
            CH.receive("typeMedecin");
            System.err.println("Etat 3");
            CA.send("code");
            System.err.println("Etat 4");
            CA.send("demandePlages");
            System.err.println("Etat 5");
            CA.receive("plagesLibres");
            System.out.println("Etat 6");
            if (randomPlace(0, 100) <= 80) {
                System.out.println("Etat 7");
                CH.send("heureDateRdzVs");
                System.out.println("Etat 8");
            } else {
                System.out.println("Etat 9");
                CH.send("pasPossible");
                System.out.println("Etat 10");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}