import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Created by rishabhkhanna on 20/03/18.
 */
public class ModelPeer {
    int id;
    String host;
    int port;
    int fileInfo;

    PeerProcess.PeerServer server;
    PeerProcess.PeerClient client;

    public PeerProcess.PeerServer getServer() {
        return server;
    }

    public void setServer(PeerProcess.PeerServer server) {
        this.server = server;
    }

    public PeerProcess.PeerClient getClient() {
        return client;
    }

    public void setClient(PeerProcess.PeerClient client) {
        this.client = client;
    }

    PrintWriter out;
    BufferedReader in;

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public ModelPeer(int id, String host, int port, int fileInfo) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.fileInfo = fileInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(int fileInfo) {
        this.fileInfo = fileInfo;
    }
}
