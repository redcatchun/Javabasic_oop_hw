package Bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Ho gia dinh
 */
public class Family {
    // thuoc tinh
    private int numOfMember;// so luong thanh vien
    private List<Person> listMember;// danh sach thanh vien
    private String address;// dia chi nha

    // Khoi tao 1 doi tuong voi dia chi nha
    public Family(String address) {
        this.address = address;
        this.numOfMember = 0;
        listMember = new ArrayList<>();
    }

    /**
     * @description: Them moi mot thanh vien
     * @param:
     * @return: true neu them thanh cong
     */
    public boolean addPerson() {
        Scanner sc = new Scanner(System.in);
        try {
            // Nhap du lieu ve nguoi can them
            System.out.print("Nhap Ho va ten nguoi can them: ");
            String name = sc.nextLine();
            System.out.print("Nhap tuoi: ");
            int age = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap nghe nghiep: ");
            String job = sc.nextLine();
            System.out.print("Nhap CMND: ");
            long idCard = Long.parseUnsignedLong(sc.nextLine());
            // them nguoi moi vao danh sach listMember cua gia dinh hien tai
            // co the them ham check ID, update lai so luong thanh vien trong gia dinh
            listMember.add(new Person(name, age, job, idCard));
            numOfMember++;
            return true;
        } catch (Exception e) {
            System.out.println("Error: Nhap sai cu phap");
            return false;
        } finally {
            numOfMember = listMember.size();
        }
    }

    public int getNumOfMember() {
        return numOfMember;
    }

    public void setNumOfMember(int numOfMember) {
        this.numOfMember = numOfMember;
    }

    public List<Person> getListMember() {
        return listMember;
    }

    public void setListMember(List<Person> listMember) {
        this.listMember = listMember;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Family address: " + address + "\n");
        int cout = 0;
        for (Person p : listMember) {
            cout++;
            sb.append(++cout + ". ");
            sb.append(p + "\n");
        }
        return sb.toString();
    }
}
