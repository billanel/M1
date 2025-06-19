import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class StubObjetDistant implements ObjetDistant {

    private int port;
    private String adresse;

    public StubObjetDistant(String ad, int p) {
        port = p;
        adresse = ad;
    }

    // c'est la signature de cette méthode qui va permettre au skeleton de connaître
    // la méthode à appeler
    public ObjetParam2 M1(ObjetParam1 arg) throws Exception {
        Socket s = new Socket(adresse, port);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());

        out.writeObject("M1");
        out.writeObject(arg);
        Object rep = in.readObject();

        in.close();
        out.close();
        s.close();

        return (ObjetParam2) rep;
    }

    public ObjetParam1 M2(ObjetParam2 arg) throws Exception {
        Socket s = new Socket(adresse, port);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());

        out.writeObject("M2");
        out.writeObject(arg);
        Object rep = in.readObject();

        in.close();
        out.close();
        s.close();

        return (ObjetParam1) rep;
    }

}
