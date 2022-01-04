package Bai2;

/**
 * Class Book
 */
public class Book extends Document {
    //Thuoc tinh tac gia va so troang sach
    private String author;
    private int pageNum;

    public Book(int id, String name, String nxb, int releaseNum, String author, int pageNum) {
        super(id, name, nxb, releaseNum);
        this.author = author;
        this.pageNum = pageNum;
        this.numType = TypeOfDocument.BOOK.getNumOfType();
    }

    @Override
    public String toString() {
        return "ID = " + id +
                " | Book: " + name  +
                " author: " + author  +
                " pageNum: " + pageNum +
                " nxb: " + nxb  +
                " releaseNum: " + releaseNum;
    }
}
