import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Collection;

public class SyncSocket extends Socket {

    private Socket s;
    private BufferedReader in;
    private PrintWriter out;

    public SyncSocket(Socket s) throws IOException {
        this.s = s;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
    }

    public SyncSocket(String host, int port) throws IOException {
        this(new Socket(host, port));
    }

    public void send(String msg) throws IOException {
        out.println(msg);
        while (!in.readLine().equals("OK" + msg)) {
        }
        ;
    }

    public void receive(String ms) throws IOException {
        while (!in.readLine().equals(ms)) {
        }
        ;
        out.println("OK" + ms);
    }

    public String receive(Collection<String> msgs) throws IOException {
        String msg;
        while (!msgs.contains(msg = in.readLine())) {
        }
        out.println("OK" + msg);
        return msg;
    }
}
