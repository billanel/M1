public class Philosophe extends Thread {

    private String nom;
    private JTuple FG, FD; // template des fourchettes / modèle
    private JTupleSpace table;

    public Philosophe(String nom, JTuple FG, JTuple FD, JTupleSpace table) {
        this.nom = nom;
        this.FG = FG;
        this.FD = FD;
        this.table = table;
    }

    public void go() {
        while (true) {
            try {
                sleep(1000); // temp pour penser
                table.EXT(FD);
                table.EXT(FG);
                sleep(1000); // temp pour manger
                table.ECR(FG);
                table.ECR(FD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        go();
    }

}
