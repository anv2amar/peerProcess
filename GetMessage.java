import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by rishabhkhanna on 22/03/18.
 */
public class GetMessage {
    public byte[] getChoke() throws IOException {
        ModelMessage choke = new ModelMessage("CHOKE", "1");
        return buildMessage(choke,null);
    }
    public byte[] getUnChoke() throws IOException {
        ModelMessage choke = new ModelMessage("UNCHOKE", "2");
        return buildMessage(choke,null);
    }
    public byte[] getInterested() throws IOException {
        ModelMessage choke = new ModelMessage("INTERESTED", "3");
        return buildMessage(choke,null);
    }
    public byte[] getNotInterested() throws IOException {
        ModelMessage choke = new ModelMessage("NOT_INTERESTED", "4");
        return buildMessage(choke,null);
    }
    public byte[] getHave() throws IOException {
        ModelMessage choke = new ModelMessage("Have", "5");
        return buildMessage(choke,"indexfield");
    }
    public byte[] getRequest() throws IOException {
        ModelMessage choke = new ModelMessage("REQUEST", "6");
        return buildMessage(choke,"indexfield");
    }
    public byte[] getBitfield() throws IOException {
        ModelMessage choke = new ModelMessage("BITFIELD", "5");
        return buildMessage(choke,"indexfield");
    }
    public byte[] getPeice() throws IOException {
        ModelMessage choke = new ModelMessage("PIECE", "7");
        return buildMessage(choke,"indexfield");
    }

//    Helper methods to create message

    public byte[] buildMessage(ModelMessage thisMessage, String payload) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(thisMessage.getMessageName().getBytes());
        outputStream.write(thisMessage.getMessageValue().getBytes());
        if(payload != null) {
            outputStream.write(payload.getBytes());
        } else{
            outputStream.write("0000".getBytes());
        }

        return outputStream.toByteArray();
    }
}
