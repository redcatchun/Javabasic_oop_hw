package run;

import ui.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UIManager uiManager = new UIManager();
        Scanner sc = new Scanner(System.in);
        final int NEW = 1;
        while (true) {
            System.out.println("Chuong trinh quan ly nhan vien");
            System.out.println("Nhap 1: Tao nhan vien moi ");
            System.out.println("Nhap 2: Thay doi thong tin nhan vien ");
            System.out.println("Nhap 3: Xoa nhan vien ");
            System.out.println("Nhap 4: Hien thi danh sach nhan vien");
            System.out.println("Nhap 5: Thoat");
            String selete = sc.nextLine();
            switch (selete) {
                case "1": {
                    uiManager.insertEmployee(NEW);
                    break;
                }
                case "2": {
                    uiManager.updateEmployee();
                    break;
                }
                case "3": {
                    uiManager.deleteEmployee();
                    break;
                }
                case "4": {
                    uiManager.showTypeEmployee();
                    break;
                }
                case "5": {
                    return;
                }
                default:
                    System.out.println("Khong hop le");
            }
        }
    }
}
