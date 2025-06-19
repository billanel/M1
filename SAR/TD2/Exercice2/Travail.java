import java.io.IOException;

public class Travail {
    public static void main(String[] args) {
        try {
            SyncSocket CA = new SyncSocket("10.200.4.159", 1235);
            SyncSocket CT = new SyncSocket("10.200.4.159", 1236);

            ProcessusTravail pe = new ProcessusTravail(CA, CT);
            pe.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
