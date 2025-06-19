import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class SkeletonObjetDistant {

    private int port;
    private ObjetDistant od;

    public SkeletonObjetDistant(ObjetDistant o, int p) {
        od = o;
        port = p;
    }

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket s = ss.accept();
                traiterRequete(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void traiterRequete(Socket s) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            String methode = (String) in.readObject();
            Object arg = in.readObject();

            if (methode.equals("M1")) {
                ObjetParam2 rep = od.M1((ObjetParam1) arg);
                out.writeObject(rep);
            } else if (methode.equals("M2")) {
                ObjetParam1 rep = od.M2((ObjetParam2) arg);
                out.writeObject(rep);
            } else {
                throw new Exception("Méthode inconnue");
            }

            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
