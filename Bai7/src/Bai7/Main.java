package Bai7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeacherManager manager = new TeacherManager();
        while (true) {
            //Menu
            System.out.println("------------ Quan ly giao vien -----------");
            System.out.println("Nhap 1 : Them moi giao vien");
            System.out.println("Nhap 2 : Hien thi thong tin giao vien");
            System.out.println("Nhap 3 : Xoa giao vien");
            System.out.println("Nhap 4 : Kiem tra luong giao vien");
            System.out.println("Nhap 0 : Thoat khoi chuong trinh");
            String select = sc.nextLine();
            switch (select) {
                case "1": {
                    manager.addNewteacher();
                    break;
                }
                case "2": {
                    manager.showAllInfo();
                    break;
                }
                case "3": {
                    manager.deleteTeacher();
                    break;
                }
                case "4": {
                    System.out.println(manager.checkSalary());
                    break;
                }
                case "0":
                    return;
                default:
                    System.out.println("Khong hop le");
            }
        }
    }
}
