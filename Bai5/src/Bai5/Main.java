package Bai5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel(10);
        for (int i = 1; i < 4; i++) {
            hotel.setRoomType(new RoomA(i));
            hotel.setRoomType(new RoomA(i+3));
            hotel.setRoomType(new RoomA(i+6));
        }
        while (true) {
            int select;
            Long idCard;
            // menu
            System.out.println("-------Quan ly khach san --------");
            System.out.println("Nhap 1 De them khach hang moi");
            System.out.println("Nhap 2 de thue phong theo CMND");
            System.out.println("Nhap 3 de thanh toan");
            System.out.println("Nhap 4 de xoa khach hang theo CMND");
            System.out.println("Nhap 5 de ket thuc");
            // Nhap lua chon va idcard
            try {
                select = Integer.parseInt(sc.nextLine());
                if (select < 0 || select > 5) throw new Exception();

                System.out.print("---- Nhap CMND: ");
                idCard = Long.parseUnsignedLong(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhap sai cu phap");
                continue;
            }
            switch (select) {
                case 1: {
                    System.out.println("------- Tao khach hang moi -------");
                    hotel.addCustomer(idCard);
                    break;
                }
                case 2: {
                    System.out.println("---------- Thue phong theo CMND ----------");
                    hotel.rentARoom(idCard);
                    break;
                }
                case 3: {
                    System.out.println("--------Thanh toan phong theo CMND ------");
                    int money = hotel.payById(idCard);
                    // hotel.resetRoom(idCard);
                    break;
                }
                case 4: {
                    System.out.println("---------Xoa khach hang khoi bo nho-------");
                    if(hotel.deleteCusById(idCard)) System.out.println("Da xoa thanh cong");
                            else System.out.println("Khong ton tai khach hang");
                    break;
                }
                case 5: {
                    return;
                }
            }
        }
    }
}
