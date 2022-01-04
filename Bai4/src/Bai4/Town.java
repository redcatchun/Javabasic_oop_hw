package Bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class khu pho: chua cac method them moi mot hay nhieu ho dan,
 */
public class Town {
    private int totalPerson;// Tong so nguoi sinh song
    private int totalFamily;// Tong so luong ho gia dinh
    private List<Family> listFamily;// Danh sach ho gia dinh

    public Town() {
        this.totalFamily = 0;
        listFamily = new ArrayList<>();
    }

    /**
     * @description: Them moi mot ho gia dinh
     * @param:
     * @return: -1 neu loi cu phap, 0 neu them khong thanh cong, 1 neu them thanh cong
     */
    public int addNewFamily() {
        Scanner sc = new Scanner(System.in);
        int numOfMember = 0;
        // Nhap du lieu, kiem tra cu phap
        System.out.print("Nhap so luong thanh vien cua gia dinh moi: ");
        try {
            numOfMember = Integer.parseUnsignedInt(sc.nextLine());
            if (numOfMember == 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("Error: Nhap so luong thanh vien phai >= 1");
            return -1;
        }
        // Tiep tuc
        System.out.print("Nhap dia chi nha: ");
        String address = sc.nextLine();
        Family newFamily = new Family(address);
        boolean checkFamilyIsCorrect = false;
        // Them So luong nguoi = numOfMember vao newFamily
        // Neu gia dinh moi co >=1 nguoi, bien check tra ve true
        for (int i = 1; i <= numOfMember; i++) {
            System.out.println("- Nguoi thu " + i + "------------");
            if (newFamily.addPerson()) {
                checkFamilyIsCorrect = true;
                System.out.println("* Them nguoi moi thanh cong ");
            } else System.out.println("* Them nguoi moi khong thanh cong");
        }
        // Them gia dinh moi vao list Family cua khu pho
        if (checkFamilyIsCorrect) this.addFamily(newFamily);
        return checkFamilyIsCorrect ? 1 : 0;
    }

    /**
     * @description: Them family vao list family, cap nhap lai so ho gia dinh, so nguoi
     * @param: Family family
     * @return:
     */
    public void addFamily(Family family) {
        listFamily.add(family);
        totalFamily++;
        totalPerson += family.getNumOfMember();
    }

    /**
     * @description: Bo sung mot list family vao lít hien tai, cap nhap thong tin
     * @param:
     * @return:
     */
    public void addFamily(List<Family> familyList) {
        listFamily.addAll(familyList);
        totalFamily = listFamily.size();
        familyList.forEach(f -> totalPerson += f.getNumOfMember());
    }

    public int getTotalPerson() {
        return totalPerson;
    }


    public int getTotalFamily() {
        return totalFamily;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--------------Khu pho-------------\n");
        int cout = 0;
        sb.append("Tong so luong nguoi sinh song : " + totalPerson + "\n");
        sb.append("Tong so luong ho gia dinh : " + totalFamily + "\n");
        for (Family f : listFamily) {
            sb.append(++cout + " | ");
            sb.append("-" + f + "\n");
        }
        return sb.toString();
    }
}
