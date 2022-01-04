package Bai8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            //Menu
            System.out.println("------------ Quan ly thu vien -----------");
            System.out.println("Nhap 1 : Them moi the muon sach moi");
            System.out.println("Nhap 2 : Hien thi thong tin cac the muon");
            System.out.println("Nhap 3 : Them ma phieu muon moi");
            System.out.println("Nhap 4 : Xoa ma phieu muon");
            System.out.println("Nhap 0 : Thoat khoi chuong trinh");
            String select = sc.nextLine();
            switch (select) {
                case "1": {
                    manager.addNewCard();
                    break;
                }
                case "2": {
                    manager.showAllCard();
                    break;
                }
                case "3": {
                    manager.addBookIdToCard();
                    break;
                }
                case "4": {
                    manager.deleteBookId();
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
