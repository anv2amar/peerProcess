/**
 * Created by rishabhkhanna on 19/03/18.
 */
public class CommonConfig {
    private int numberPrefferedNeighbours;
    private int unchokingInterval;
    private int optimisticUnchokingInterval;
    private String fileName;
    private int fileSize;
    private int pieceSize;

    public CommonConfig(int numberPrefferedNeighbours, int unchokingInterval, int optimisticUnchokingInterval, String fileName, int fileSize, int pieceSize) {
        this.numberPrefferedNeighbours = numberPrefferedNeighbours;
        this.unchokingInterval = unchokingInterval;
        this.optimisticUnchokingInterval = optimisticUnchokingInterval;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.pieceSize = pieceSize;
    }

    public CommonConfig() {
    }

    public int getNumberPrefferedNeighbours() {
        return numberPrefferedNeighbours;
    }

    public void setNumberPrefferedNeighbours(int numberPrefferedNeighbours) {
        this.numberPrefferedNeighbours = numberPrefferedNeighbours;
    }

    public int getUnchokingInterval() {
        return unchokingInterval;
    }

    public void setUnchokingInterval(int unchokingInterval) {
        this.unchokingInterval = unchokingInterval;
    }

    public int getOptimisticUnchokingInterval() {
        return optimisticUnchokingInterval;
    }

    public void setOptimisticUnchokingInterval(int optimisticUnchokingInterval) {
        this.optimisticUnchokingInterval = optimisticUnchokingInterval;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getPieceSize() {
        return pieceSize;
    }

    public void setPieceSize(int pieceSize) {
        this.pieceSize = pieceSize;
    }

    public static void main(String[] args) {

    }

}
