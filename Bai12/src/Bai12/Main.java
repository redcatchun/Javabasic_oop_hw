package Bai12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            // Menu chinh
            System.out.println("---------- Quan ly phuong tien giao thong ----------");
            System.out.println("Enter 1: Them phuong tien");
            System.out.println("Enter 2: Xoa phuong tien ");
            System.out.println("Enter 3: Tim phuong tien theo hang san suat va mau");
            System.out.println("Enter 0: Thoat");
            String slt = sc.nextLine();
            switch (slt) {
                case "1": {
                    System.out.println("--------Them moi phuong tien ---------");
                    System.out.println("Enter 1: Them xe con");
                    System.out.println("Enter 2: Them xe may ");
                    System.out.println("Enter 3: Them xe tai");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.println(type);
                    if (type == 1 || type ==2 || type ==3) {
                        System.out.println("Nhap id phuong tien moi: ");
                        String id = sc.nextLine();
                        manager.addNewVehical(id, type);
                    } else System.out.println("Khong hop le");
                    break;
                }
                case "2": {
                    System.out.println("---------Xoa phuong tien -------------");
                    System.out.println("Nhap id phuong tien moi: ");
                    String id = sc.nextLine();
                    manager.deleteById(id);
                    break;
                }
                case "3": {
                    System.out.println("---------Tim phuong tien theo hang san xuat va mau sac ----------");
                    System.out.println("Nhap Hang san xuat: ");
                    String manufacturer = sc.nextLine();
                    System.out.println("Nhap Mau sac: ");
                    String color = sc.nextLine();
                    manager.searchVehicleBy(manufacturer,color);
                break;
                }
                case "0": {
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }

        }
    }
}
