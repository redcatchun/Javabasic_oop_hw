package Bai6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        School school=new School();
        while (true) {
            //Menu
            System.out.println("------------ Quan ly hoc sinh -----------");
            System.out.println("Nhap 1 : Them moi hoc sinh");
            System.out.println("Nhap 2 : Hien thi thong tin hoc sinh 20 tuoi");
            System.out.println("Nhap 3 : Kiem tra so luong hoc sinh 23 tuoi va que o DN");
            System.out.println("Nhap 0 : Thoat khoi chuong trinh");
            String select = sc.nextLine();
            switch (select) {
                case "1": {
                    school.addnewStudent();
                    break;
                }
                case "2": {
                    System.out.println("------ Danh sach hoc sinh tren 20 tuoi ------");
                    school.filterByAge(20).forEach(System.out::println);
                    break;
                }
                case "3": {
                    System.out.println("------ Hoc sinh duoi 23 tuoi va qua o DN -----");
                    System.out.println("So luong: "+school.filterWithHomeTown(school.filterByAge(23),"DN"));
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
