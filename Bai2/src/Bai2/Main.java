package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            // Menu chinh
            System.out.println("---------- Manager Document Application ----------");
            System.out.println("Enter 1: To insert document");
            System.out.println("Enter 2: To search document by category: ");
            System.out.println("Enter 3: To show information documents");
            System.out.println("Enter 4: To remove document by id");
            System.out.println("Enter 5: To exit:");
            String selecte = scanner.nextLine();
            switch (selecte) {
                case "1": {
                    manager.doInsertDoc();
                    break;
                }
                case "2": {
                    manager.doFindDoc();
                    break;
                }
                case "3": {
                    manager.showAllDoc();
                    break;
                }
                case "4": {
                    manager.doDeleteDoc();
                }
                break;
                case "5": {
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }

        }
    }
}
