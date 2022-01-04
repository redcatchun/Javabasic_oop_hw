package Bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class hotel de quan ly khach san
 */
public class Hotel {
    private int maxRoom;// tong so phong trong khach san
    private Room[] listRoom;// danh sach phong
    private List<Person> cutomers;//danh sach khach da dang ky

    public Hotel(int maxRoom) {
        this.maxRoom = maxRoom;
        this.listRoom = new Room[maxRoom];
        cutomers = new ArrayList<>();
    }

    /**
     * @description: Dat kieu phong, thay the kieu phong mac dinh
     * @param: Tung loai phong
     * @return: true neu thanh cong, false neu so phong > max
     */
    public boolean setRoomType(Room room) {
        if (room.getRoomNum() <= maxRoom) {
            // thay the room ban dau trong list bang room nhap vao
            listRoom[room.getRoomNum()] = room;
            return true;
        } else return false;
    }

    /**
     * @description: Xac nhan khach hang bang id
     * @param: so CMND
     * @return: Person object neu thang cong hoac null neu id chua duoc dang ky
     */
    public Person getCusFromId(long idCard) {
        return cutomers.stream().filter(c -> c.getIdCard() == idCard).findFirst().orElse(null);
    }

    /**
     * @description: Them moi mot khach hang theo id
     * @param: CMND
     * @return: Person object neu thang cong hoac null that bai
     */
    public Person addCustomer(long idCard) {
        Scanner sc = new Scanner(System.in);
        try {
            // Nhap du lieu
            System.out.print("Nhap ten khach hang: ");
            String name = sc.nextLine();
            System.out.print("Nhap tuoi: ");
            int age = Integer.parseInt(sc.nextLine());
            // Tao doi tuong khach hang moi newCus
            Person newCus = new Person(name, age, idCard);
            Person p = getCusFromId(idCard);
            if (p != null) {
                System.out.println("Khach hang da ton tai, auto update thong tin");
                cutomers.remove(newCus);
            }
            // Them khach hang vao list
            cutomers.add(newCus);
            return newCus;
        } catch (Exception e) {
            System.out.println("Nhap thong tin sai cu phap");
            return null;
        }
    }

    /**
     * @description: Thue phong theo id
     * @param: CMND
     * @return: true neu thanh cong/false neu that bai
     */
    public boolean rentARoom(long idCard) {
        Scanner sc = new Scanner(System.in);
        Person cus = getCusFromId(idCard);
        System.out.println("Nhap so phong muon thue: ");
        if (cus == null) {
            // id chua ton tai
            System.out.println("Khong ton tai khach hang voi CMND nay, yeu cau tao moi");
            return false;
        }
        // id da ton tai
        try {
            int room = Integer.parseInt(sc.nextLine());
            if (listRoom[room].getPersonID() > 0) {
                System.out.println("Phong dang duoc thue, doi phong khac");
                return false;
            } else {
                System.out.println("Nhap so ngay can thue: ");
                int rentalTime = Integer.parseInt(sc.nextLine());
                // Truy cap vao doi tuong room duoc thue, sua lai thuoc tinh
                listRoom[room].hireByID(idCard, rentalTime);
                cus.setRoom(room);// Them room duoc thue vao obj khach hang
                return true;
            }
        } catch (Exception e) {
            System.out.println("Nhap gia tri khong hop le");
            return false;
        }
    }

    /**
     * @description: Xoa khach hang theo id ra khoi list khach hang
     * @param: CMND
     * @return: true neu thanh cong/ flase neu khong co
     */
    public boolean deleteCusById(long idCard) {
        try {
            return cutomers.remove(getCusFromId(idCard));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @description: Tra tien phong xac nhan theo id
     * @param: cmnd
     * @return: int =1 neu thanh cong/ <0 neu loi xay ra
     */
    public int payById(long idCard) {
        Person cus = getCusFromId(idCard);
        if (cus != null) {
            int room = cus.getRoom();
            if (room == -1) {
                System.out.println("Khach hang chua thue phong");
                return -1;
            }
            System.out.println("So tien phai thanh toan cho phong " + room + " la " + listRoom[room].getCost());
            return 1;
        } else {
            System.out.println("Khach hang khong co trong danh sach");
            return -2;
        }
    }

    /**
     *@description: reset trang thai phong sau khi duoc thanh toan
     *@param: id nguoi thanh toan
     *@return:
     */
    public void resetRoom(long idCard) {
        Person cus = getCusFromId(idCard);
        listRoom[cus.getRoom()].reset();
        cus.setRoom(-1);
    }


}
