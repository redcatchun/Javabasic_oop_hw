package Bai9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            //Menu
            System.out.println("------------ Quan ly Cong to dien -----------");
            System.out.println("Nhap 1 : Them moi khach hang");
            System.out.println("Nhap 2 : Chinh sua khach hang");
            System.out.println("Nhap 3 : Xoa khach hang");
            System.out.println("Nhap 4 : Hien thi danh sach cong to dang su dung");
            System.out.println("Nhap 5 : Thanh toan");
            System.out.println("Nhap 0 : Thoat khoi chuong trinh");
            String select = sc.nextLine();
            switch (select) {
                case "1": {
                    manager.addNewCustomer();
                    break;
                }
                case "2": {
                    manager.editCustomer();
                    break;
                }
                case "3": {
                    manager.deleteCustomer();
                    break;
                }
                case "4": {
                    manager.showMeterInfo();
                    break;
                }
                case "5": {
                    manager.getBill();
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