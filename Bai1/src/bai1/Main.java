package bai1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Khoi tao cac bien ban dau cho chuong trinh
        Scanner scanner = new Scanner(System.in);
        // tao obj quan ly
        Manager manager = new Manager();
        while (true) {
            // Hien thi menu
            System.out.println("---------Manager Officer----------");
            System.out.println("Enter 1: To insert officer");
            System.out.println("Enter 2: To search officer by name ");
            System.out.println("Enter 3: To show information of officers");
            System.out.println("Enter 4: To exit:");
            String select1 = scanner.nextLine();
            switch (select1) {
                case "1": {
                    // Thuc hieu them can bo
                    manager.doInsertOfficer();
                    break;
                }
                case "2": {
                    // Thuc hien tim kiem can bo theo ten
                    System.out.println("---------- Sort by Name ----------");
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    int total = manager.searchByName(name);
                    System.out.println("Total: " + total);
                    break;
                }
                case "3": {
                    System.out.println("------------Information ----------");
                    // Hien thi danh sach thong tin can bo
                    manager.showListInfo();
                    break;
                }
                case "4": {
                    // Exit
                    return;
                }
                default:
                    // Loi cu phap
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
