import java.io.IOException;

public class Employe {
    public static void main(String[] args) {
        try {
            SyncServerSocket CHserverSocket = new SyncServerSocket(1234);
            SyncServerSocket CTserverSocket = new SyncServerSocket(1236);
            SyncSocket CH = CHserverSocket.accept();
            SyncSocket CT = CTserverSocket.accept();

            ProcessusEmploye pe = new ProcessusEmploye(CH, CT);
            pe.start();

            CHserverSocket.close();
            CTserverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
