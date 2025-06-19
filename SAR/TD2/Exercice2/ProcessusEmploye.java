import java.util.Collection;
import java.util.HashSet;
import java.io.IOException;

public class ProcessusEmploye {

    SyncSocket CH;
    SyncSocket CT;

    public ProcessusEmploye(SyncSocket ch, SyncSocket ct) {
        this.CH = ch;
        this.CT = ct;
    }

    public void start() {
        try {
            System.err.println("Etat 0");
            CH.send("demandeRdzVs");
            System.err.println("Etat 1");
            CH.receive("code");
            System.err.println("Etat 2");
            CH.send("typeMedecin");
            System.err.println("Etat 3");
            CT.send("autorisation");
            System.err.println("Etat 4");
            CT.send("code");
            System.err.println("Etat 5");
            Collection<String> msgs = new HashSet<>();
            msgs.add("heureDateRdzVs");
            msgs.add("pasPossible");
            CT.receive(msgs);
            System.out.println("Etat 6");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}