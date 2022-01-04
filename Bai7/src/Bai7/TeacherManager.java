package Bai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class quan ly giao vien
 */
public class TeacherManager {
    private List<Teacher> teacherList;// danh sach giao vien

    public TeacherManager() {
        this.teacherList = new ArrayList<>();
    }

    /**
     *@description: Hien thi thong tin tat ca giao vien
     *@param:
     *@return:
     */
    public void showAllInfo() {
        teacherList.forEach(System.out::println);
    }

    /**
     *@description: Tim kiem giao vien theo id
     *@param: int id
     *@return: Teacher obj neu tim duoc hoac null
     */
    public Teacher findByID(int id) {
        return teacherList.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    /**
     *@description: Them giao vien vao danh sach
     *@param: Teacher teacher
     *@return:
     */
    public void add(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    /**
     *@description: Them moi 1 giao vien
     *@param:
     *@return:
     */
    public void addNewteacher() {
        Scanner sc = new Scanner(System.in);
        //menu va nhap du lieu
        System.out.println("------- Them moi giao vien -------");
        try {
            // Nhap du lieu
            System.out.print("Nhap ID ");
            int id = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap Ho va ten: ");
            String name = sc.nextLine();
            System.out.print("Nhap tuoi: ");
            int age = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap que quan: ");
            String homeTown = sc.nextLine();
            System.out.print("Nhap luong cung:");
            double salary = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap luong thuong:");
            double bonus = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap luong phat:");
            double penalty = Double.parseDouble(sc.nextLine());
            // Kiem tra giao vien da ton tai chua va them moi vao list
            Teacher oldTeacher = findByID(id);
            Teacher newTeacher = new Teacher(id, name, age, homeTown, salary, bonus, penalty);
            if (oldTeacher != null) {
                System.out.println("Giao vien da ton tai, Cap nhap lai thong tin");
                teacherList.remove(oldTeacher);
            }
            teacherList.add(newTeacher);
            System.out.println("Thanh cong");
            // hien thi ket qua
        } catch (Exception e) {
            System.out.println("Gia tri nhap khong hop le");
            return;
        }
    }

    /**
     *@description: ham nhap id tu ban phim, check loi
     *@param:
     *@return: id neu hop le hoac 0 neu loi
     */
    public int enterID() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap ID ");
            int id = Integer.parseUnsignedInt(sc.nextLine());
            if (id < 1) throw new NumberFormatException();
            return id;
        } catch (NumberFormatException e) {
            System.out.println("Nhap ID khong hop le");
            return 0;
        }
    }

    /**
     *@description: thuc hien xoa giao vien
     *@param:
     *@return: true neu xoa/flase neu khong
     */
    public boolean deleteTeacher() {
        System.out.println("----------Xoa giao vien ---------");
        System.out.print("Nhap ID giao vien can xoa: ");
        int id = enterID();
        if (id != 0) {
            Teacher teacher = findByID(id);
            if (teacher == null) {
                return false;
            }
            teacherList.remove(teacher);
            return true;
        } else return false;

    }

    /**
     *@description: thuc hien lay gia tri tien luong thuc te
     *@param:
     *@return: Thong bao luong/loi
     */
    public String checkSalary() {
        System.out.println("--------Kiem tra luong thuc te -------");
        System.out.print("Nhap ID giao vien can kiem tra: ");
        int id = enterID();
        if (id != 0) {
            Teacher teacher = findByID(id);
            if (teacher == null) {
                return "Khong co giao vien";
            }
            return "Luong giao vien: "+teacher.getRealSalary();
        } else return "";
    }

}
