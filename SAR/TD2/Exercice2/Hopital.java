import java.io.IOException;

public class Hopital {
    public static void main(String[] args) {
        try {
            SyncSocket CH = new SyncSocket("10.200.4.159", 1234);
            SyncServerSocket CAserverSocket = new SyncServerSocket(1235);
            SyncSocket CA = CAserverSocket.accept();

            ProcessusHopital ph = new ProcessusHopital(CH, CA);
            ph.start();

            CAserverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
