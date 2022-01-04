package Bai4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Town town1 = new Town();
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);
        //Menu
        while (true) {
            System.out.println("--------------Quan ly khu pho-----------");
            System.out.println("Nhap 1: Them moi ho gia dinh");
            System.out.println("Nhap 2: Hien thi thong tin cac ho gia dinh");
            System.out.println("Nhap 0: Thoat chuong trinh");
            String select = sc.nextLine();
            switch (select) {
                case "1": {
                    System.out.println("-----------Them ho gia dinh -------------");
                    System.out.print("Nhap so luong ho can them: ");
                    try{
                        int slHo = Integer.parseUnsignedInt(sc.nextLine());
                        manager.addFamilytoTown(town1, slHo);
                    }catch (Exception e){
                        System.out.println("Nhap gia tri khong hop le");
                    }
                    break;
                }
                case "2": {
                    System.out.println("-----------Thong tin cac ho dan ----------");
                    manager.showTownInfo(town1);
                    break;
                }
                case "0":
                    return;
                default: {
                    System.out.println("Nhap sai cu phap");
                }
            }
        }
    }
}
