package Bai2;

/**
 * Enum luu cac kieu Document, cac string can thiet su dung
 */
public enum TypeOfDocument {
    BOOK(1, "author", "page number"),
    JOURNAL(2, "release number", "release month"),
    NEWSPAPER(3, "release date", "");

    // Number of type Document, thuoc tinh dac biet1,2,...
    private int numOfType;
    private String speAtt1;
    private String SpeAtt2;

    TypeOfDocument(int numOfType, String speAtt1, String speAtt2) {
        this.numOfType = numOfType;
        this.speAtt1 = speAtt1;
        this.SpeAtt2 = speAtt2;
    }

    public int getNumOfType() {
        return numOfType;
    }

    public String getSpeAtt1() {
        return speAtt1;
    }

    public String getSpeAtt2() {
        return SpeAtt2;
    }
}
