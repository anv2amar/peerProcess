



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by rishabhkhanna on 20/03/18.
 */
public class HandShake {
    public static byte[] getHandShakeMessage(int peerId) throws IOException {
        byte[] handshakeHeader = "P2PFILESHARINGPROJ".getBytes();
        byte[] zeroBits = "0000000000".getBytes();
        byte[] peerID = String.valueOf(peerId).getBytes();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(handshakeHeader);
        outputStream.write(zeroBits);
        outputStream.write(peerID);

        byte[] returnThis = outputStream.toByteArray();

        return returnThis;
    }

    public static String getMessage(int peerId){
        return String.valueOf(peerId);
    }
}
