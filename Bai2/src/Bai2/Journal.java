package Bai2;

/**
 * Class tap chi
 */
public class Journal extends Document {
    // thuoc tinh so phat hanh va thang phat hanh
    private int issueNum;
    private int releaseMon;

    public Journal(int id, String name, String nxb, int releaseNum, int issueNum, int releaseMon) {
        super(id, name, nxb, releaseNum);
        this.issueNum = issueNum;
        this.releaseMon = releaseMon;
        this.numType = TypeOfDocument.JOURNAL.getNumOfType();
    }

    @Override
    public String toString() {
        return "ID = " + id +
                " | Journal: " + name +
                " release Month: " + releaseMon +
                " issue Number: " + issueNum +
                " nxb: " + nxb +
                " releaseNum: " + releaseNum;
    }
}
