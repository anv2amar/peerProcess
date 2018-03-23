import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rishabhkhanna on 22/03/18.
 */
public class LogPeerInfo {


        SimpleDateFormat timeFormatter = new SimpleDateFormat("E yyyy/MM/dd 'at' hh:mm:ss a zzz");
        Date time = new Date();
        BufferedWriter writer;

//Logs Constructor

        public LogPeerInfo(BufferedWriter writer){
            timeFormatter = new SimpleDateFormat("E yyyy/MM/dd 'at' hh:mm:ss a zzz");
            this.writer = writer;
        }


// log entry when a peer makes a connection to another peer

        public void tcpConnectionTo(int id_1,int id_2){
            time = new Date();
            String log = new String("");
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " makes a connection to Peer " + id_2 + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer is connected from another peer

        public void tcpConnectionFrom(int id_1,int id_2){
            time = new Date();
            String log = new String("");
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " is connected from Peer " + id_2 + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer changes its preferred neighbors

        public void changeOfPreferredNeighbors(int id_1, int[] id_List){
            time = new Date();
            String log = new String("");
            StringBuilder idCommaSeperated = new StringBuilder();

            for(int id = 0; id< id_List.length-1 ; id++){
                idCommaSeperated.append(id_List[id]);
                idCommaSeperated.append(',');
            }

            idCommaSeperated.append(id_List[id_List.length-1]);

            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " has the preferred neighbors " + idCommaSeperated + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer changes optimistically unchoked neighbor

        public void changeOfOptimisticallyUnchokedNeighbor(int id_1, int id_2){
            time = new Date();
            String log = new String("");
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " has the optimistically unchoked neighbor " + id_2 + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer is unchoked by a neighbor

        public void unchoking(int id_1, int id_2){
            time = new Date();
            String log = new String();
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " is unchoked by " + id_2 + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer is choked by a neighbor

        public void choking(int id_1, int id_2){
            time = new Date();
            String log = new String();
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " is choked by " + id_2 + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer receives 'have' message

        public void haveReceived(int id_1, int id_2, int pieceIndex){
            time = new Date();
            String log = new String();
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " received the 'have' message from " + id_2 + " for the piece " + pieceIndex + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer receives 'interested' message

        public void interestedReceived(int id_1, int id_2){
            time = new Date();
            String log = new String();
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " received the 'interested' message from " + id_2 + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer receives 'not interested' message

        public void notInterestedReceived(int id_1, int id_2){
            time = new Date();
            String log = new String();
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " received the 'not interested' message from " + id_2 + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer finishes downloading a piece

        public void downloadingPiece(int id_1, int id_2, int pieceIndex, int pieceCount){
            time = new Date();
            String log = new String();
            log = (timeFormatter.format(time) + " : " + "Peer " + id_1 + " has downloaded the piece " + pieceIndex + " from " + id_2 + ". Now the number of pieces it has is " + pieceCount + ".");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }

// log entry when a peer finishes downloading a file

        public void completionOfDownload(int id){
            time = new Date();
            String log = new String();
            log = (timeFormatter.format(time) + " : " + "Peer " + id + " has downloaded the complete file. ");
            //System.out.println(log);
            try{
                writer.write(log);
                writer.newLine();
                writer.flush();
            }
            catch(Exception e){
            }
        }
}
