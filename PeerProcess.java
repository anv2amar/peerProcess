import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rishabhkhanna on 20/03/18.
 */
public class PeerProcess {

    static int total = 0;

    public static void main(String[] args) throws IOException {
        String readThis;

        ArrayList<ModelPeer> allPeers = new ArrayList<>();
        if (args != null) {
            FileReader fileReader = new FileReader("PeerInfo.cfg");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((readThis = bufferedReader.readLine()) != null) {

                String[] thisPeer = readThis.split("\\s+");
                Helper.printLog(thisPeer[0]);
                ModelPeer currentPeer = new ModelPeer(Integer.valueOf(thisPeer[0]), thisPeer[1], Integer.valueOf(thisPeer[2]), Integer.valueOf(thisPeer[3]));
//              This is method is used to create a new file
                createFile(currentPeer);
                allPeers.add(currentPeer);

                PeerServer peerServer = new PeerServer(currentPeer);
                PeerClient peerClient = new PeerClient(currentPeer, allPeers);


                peerServer.start();
                peerClient.start();
                currentPeer.setServer(peerServer);
                currentPeer.setClient(peerClient);


            }
        } else {
            String arg = args[0];
            String port = args[1];
            ModelPeer peer = new ModelPeer(Integer.valueOf(arg), "0.0.0.0", Integer.valueOf(port), 1);
            allPeers.add(peer);

            PeerServer peerServer = new PeerServer(peer);
            PeerClient peerClient = new PeerClient(peer, allPeers);


            peerServer.start();
            peerClient.start();
            peer.setServer(peerServer);
            peer.setClient(peerClient);

        }
    }

    public static Boolean createFile(ModelPeer thisPeer){
        File createFile = new File("peer_" + thisPeer.getId());
        return createFile.mkdir();

    }


    //client server
    public static class PeerServer extends Thread {
        ServerSocket serverSocket;
        Socket socket;
        ModelPeer thisPeer;


        public PeerServer(ModelPeer thisPeer) throws IOException {
            Helper.printLog("port " + thisPeer.getPort());
            this.serverSocket = new ServerSocket(thisPeer.getPort());
            this.thisPeer = thisPeer;
        }

        @Override
        public void run() {

            try {

//                out.println(HandShake.getHandShakeMessage(id));
                while (true) {
//                    byte[] buffer = new byte[500];
//                    is.read(buffer);
                    this.socket = serverSocket.accept();
                    InputStream is = socket.getInputStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String line = in.readLine();


//                    String input = new String(in.re);
//                    if(input == null || input.equals("")){
//                        Helper.printLog("Server crashed, invalid input");
//                        break;
//                    }
//                    String thisString = new String(buffer);
//                    Helper.printLog(thisString);
                    Helper.printLog("Connection between : " + thisPeer.getId() + " and " + line);
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log_peer_" + thisPeer.getId(),true));
                    LogPeerInfo logPeerInfo = new LogPeerInfo(bufferedWriter);
                    logPeerInfo.tcpConnectionFrom(Integer.valueOf(thisPeer.getId()), Integer.valueOf(line));

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            super.run();
        }
    }

    public static class PeerClient extends Thread {
        HashMap<ModelPeer, Socket> peerSocketHashMap = new HashMap<>();
        ModelPeer thisPeer;
        ArrayList<ModelPeer> currentPeers;

        public PeerClient(ModelPeer thisPeer, ArrayList<ModelPeer> allPeers) {
            this.thisPeer = thisPeer;
            currentPeers = new ArrayList<>();
            currentPeers.addAll(allPeers);
            Helper.printLog("Size of peer s: for id " + thisPeer.getId() + " is : " + currentPeers.size());
        }

        @Override
        public void run() {

            for (ModelPeer current : currentPeers) {
                try {
                    total++;
                    if (thisPeer.getId() != current.getId()) {
                        Helper.printLog("Peers for : " + thisPeer.getId() + " are : " + current.getId());
                        Socket socket = new Socket(current.getHost(), current.getPort());

                        peerSocketHashMap.put(current, socket);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

//                        out.(HandShake.getHandShakeMessage(thisPeer.getId()));
                        out.println(HandShake.getMessage(thisPeer.getId()));

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            Helper.printLog("Total : " + total);
            super.run();
        }
    }


}
