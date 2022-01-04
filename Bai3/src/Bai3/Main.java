package Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        //Menu
        while (true) {
            System.out.println("------------ Tuyen Sinh -----------");
            System.out.println("Nhap 1 : Them moi thi sinh");
            System.out.println("Nhap 2 : Tim kiem thi sinh theo ID");
            System.out.println("Nhap 3 : Hien thi danh sach tat ca cac thi sinh");
            System.out.println("Nhap 0 : Thoat khoi chuong trinh");
            String select = sc.nextLine();
            switch (select) {
                case "1": {
                    manager.doInsert();
                    break;
                }
                case "2": {
                    manager.findById();
                    break;
                }
                case "3": {
                    manager.showAllInfo();
                    break;
                }
                case "0":
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}
