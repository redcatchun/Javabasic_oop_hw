package Bai2;

/**
 * Class bao
 */
public class Newspaper extends Document{
    // thuoc tinh ngay phat hanh
    private int releaseDate;

    public Newspaper(int id,String name,String nxb,int releaseNum,int releaseDate){
        super(id, name, nxb, releaseNum);
        this.releaseDate=releaseDate;
        this.numType=TypeOfDocument.NEWSPAPER.getNumOfType();
    }
    @Override
    public String toString() {
        return "ID = " + id +
                " | Newspaper: " + name  +
                " release date: " + releaseDate  +
                " nxb: " + nxb  +
                " releaseNum: " + releaseNum;
    }
}
