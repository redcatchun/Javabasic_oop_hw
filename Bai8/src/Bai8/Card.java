package Bai8;

/**
 * Class the muon sach
 */
public class Card {
    private String id;// id cua the
    private Student student;// Hoc sinh so huu the
    private int borrowDate;
    private int paymentDate;
    private String bookId;// Ma phieu muon sach

    public Card(String id, Student student) {
        this.id = id;
        this.student = student;
        reNew();
    }

    public Card(String id, Student student, int borrowDate, int paymentDate, String bookId) {
        this.student = student;
        this.id = id;
        this.borrowDate = borrowDate;
        this.paymentDate = paymentDate;
        this.bookId = bookId;
    }

    /**
     *@description: Dua the ve trang thai khong muon sach ( trang thai ban dau)
     *@param:
     *@return:
     */
    public void reNew() {
        borrowDate = 0;
        paymentDate = 0;
        bookId = "0x0";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(int borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(int paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "The ID =" + id + " "+ student +
                "\n Ma phieu muon: " + bookId +
                "\n Ngay muon: " + borrowDate +
                ", Ngay tra: " + paymentDate;
    }
}
