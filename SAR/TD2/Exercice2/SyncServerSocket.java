import java.net.ServerSocket;
import java.io.IOException;
import java.net.InetAddress;

public class SyncServerSocket extends ServerSocket {

    public SyncServerSocket() throws IOException {
        super();
    }

    public SyncServerSocket(int p, int b) throws IOException {
        super(p, b);
    }

    public SyncServerSocket(int p) throws IOException {
        super(p);
    }

    public SyncServerSocket(int port, int backlog, InetAddress bindAddr) throws IOException {
        super(port, backlog, bindAddr);
    }

    public SyncSocket accept() throws IOException {
        return new SyncSocket(super.accept());
    }
}