package Bai8;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class quan ly thu vien
 */
public class Manager {
    HashMap<String, Card> cardMap;//map noi id cua card - card
    HashMap<String, Card> bookMap;//map noi Ma phieu muon - card

    public Manager() {
        cardMap = new HashMap<>(100);
        bookMap = new HashMap<>(100);
    }

    /**
     *@description: Thuc hien tao hoc sinh moi
     *@param:
     *@return: new Student neu thanh cong / null neu tao khong thanh cong
     */
    private Student creatNewStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Nhap thong tin hoc sinh: ");
        try {
            // Nhap du lieu
            System.out.print("Nhap Ho va ten: ");
            String name = sc.nextLine();
            System.out.print("Nhap Tuoi: ");
            int age = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap lop: ");
            String classR = sc.nextLine().toUpperCase();
            return new Student(name, age, classR);
        } catch (Exception e) {
            System.out.println("Khong hop le");
            return null;
        }
    }

    /**
     *@description: Hien thi thong tin tat ca cac Card hien co
     *@param:
     *@return:
     */
    public void showAllCard(){
        cardMap.values().forEach(System.out::println);
    }

    /**
     *@description: Thuc hien them ma phieu muon(bookID) vao Card
     *@param:
     *@return:
     */
    public void addBookIdToCard() {
        Scanner sc = new Scanner(System.in);
        // Nhap du lieu
        System.out.println("-------Them ma phieu muon vao the ---------");
        System.out.print("Nhap ID the: ");
        String id = sc.nextLine();
        System.out.print("Nhap ma phieu muon: ");
        String bookID = sc.nextLine();
        try {
            // Thuc hien nap du lieu vao card = cardMap.get(id)
            cardMap.get(id).setBookId(bookID);
            System.out.print("Nhap ngay muon: ");
            int borrowDate = Integer.parseUnsignedInt(sc.nextLine());
            cardMap.get(id).setBorrowDate(borrowDate);
            System.out.print("Nhap ngay tra: ");
            int payDate = Integer.parseUnsignedInt(sc.nextLine());
            cardMap.get(id).setPaymentDate(payDate);
            // tao lien ket ma phieu muon - card
            bookMap.put(bookID,cardMap.get(id));
        }catch (Exception e){
            System.out.println("Nhap gia tri khong hop le");
        }
    }

    /**
     *@description: Thuc hien xoa ma phieu muon hien co
     *@param:
     *@return:
     */
    void deleteBookId(){
        Scanner sc = new Scanner(System.in);
        System.out.println("------- Xoa ma phieu muon ---------");
        System.out.print("Nhap ma phieu muon: ");
        String bookID = sc.nextLine();
        try {
            // Neu bookID ton tai thuc hien sua lai thong tin trong Card tuong ung ve trang thai ban dau
            bookMap.get(bookID).reNew();
            // Xoa lien ket bookID - card
            bookMap.remove(bookID);
            System.out.println("Xoa thanh cong");
        }catch (Exception e){
            System.out.println("Ma phieu muon khong ton tai");
        }
    }

    /**
     *@description: Thuc hien them Card muon sach moi
     *@param:
     *@return:
     */
    public void addNewCard() {
        Scanner sc = new Scanner(System.in);
        // Kiem tra ID xem ton tai hay chua
        System.out.println("------- Tao the moi--------");
        System.out.print("Nhap ID the moi: ");
        String id = sc.nextLine();
        if (cardMap.get(id) != null) {
            System.out.println("Da ton tai the co ID tren, Nhap thong tin moi");
        }
        // Tao doi tuong Student moi
        Student newStudent = creatNewStudent();
        if (newStudent != null) {
            // them lien ket idCard - Card
            cardMap.put(id, new Card(id,newStudent));
            System.out.println("Tao moi/cap nhap thanh cong");
        } else System.out.println("That bai");
    }
}
