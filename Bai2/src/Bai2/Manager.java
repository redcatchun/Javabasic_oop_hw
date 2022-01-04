package Bai2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class Manager cac Document
 */
public class Manager {
    Set<Document> documentSet;
    // MAXTYPE = so kieu document hien co
    private final int MAXTYPE = 3;

    public Manager() {
        documentSet = new HashSet<>();
    }

    /**
     * @description: them doc vao set document
     * @param: Document doc
     * @return: true-thanh cong/false - doc da ton tai
     */
    boolean addDocToSet(Document doc) {
        return documentSet.add(doc);
    }

    /**
     * @description: xoa doc from set
     * @param: Document doc
     * @return: true neu thanh cong
     */
    boolean delDocFromSet(Document doc) {
        return documentSet.remove(doc);
    }

    /**
     * @description: Ham tao moi mot doi tuong Document theo kieu type
     * @param: int type
     * @return: Document obj / null neu that bai
     */
    Document creatNewDoc(int type) {
        Scanner scanner = new Scanner(System.in);
        // Duyet Enum, kiem tra type Document can tao
        for (TypeOfDocument tOfDoc : TypeOfDocument.values()) {
            if (type == tOfDoc.getNumOfType()) {
                try {
                    //Nhap thong tin Document moi
                    System.out.println("New " + type + " :");
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String nxb = scanner.nextLine();
                    System.out.print("Enter release number: ");
                    int releaseNum = Integer.parseInt(scanner.nextLine());
                    // Nhap cac thuoc tinh dac biet cua tung loai Doc rieng
                    System.out.print("Enter " + tOfDoc.getSpeAtt1() + ":");
                    String sA1 = scanner.nextLine();
                    String sA2 = "";
                    if (!"".equals(tOfDoc.getSpeAtt2())) {
                        System.out.print("Enter " + tOfDoc.getSpeAtt2() + ":");
                        sA2 = scanner.nextLine();
                    }
                    // tao moi Document, return obj neu thanh cong
                    switch (type) {
                        case 1:
                            return new Book(id, name, nxb, releaseNum, sA1, Integer.parseInt(sA2));
                        case 2:
                            return new Journal(id, name, nxb, releaseNum, Integer.parseInt(sA1), Integer.parseInt(sA2));
                        case 3:
                            return new Newspaper(id, name, nxb, releaseNum, Integer.parseInt(sA1));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid information");
                    break;
                }
            }
        }
        // khong co type phu hop
        return null;
    }

    /**
     * @description: Ham goi qua trinh thuc hien them moi Document
     * @param:
     * @return:
     */
    void doInsertDoc() {
        while (true) {
            int select = 0;
            // menu
            System.out.println("--------Insert New Document ---------");
            for (TypeOfDocument type : TypeOfDocument.values()) {
                System.out.println("Enter " + type.getNumOfType() + " to insert a " + type);
            }
            System.out.println("Enter 0 to Back");
            try {
                Scanner sc = new Scanner(System.in);
                select = sc.nextInt();
                if (select == 0) return;
                if (select < 0 || select > MAXTYPE) throw new InputMismatchException("Invalid");
            } catch (InputMismatchException e) {
                System.out.println("Invalid");
                continue;
            } catch (Exception e) {
                System.out.println("Break " + e);
            }
            // Tao moi mot Document
            Document newDoc = creatNewDoc(select);
            // neu newDoc khac null, them vao set
            if (Optional.ofNullable(newDoc).isPresent()) {
                if (addDocToSet(newDoc)) System.out.println("Insert done");
                else System.out.println("New Document has the same id with other");
            }
            // continue while loop
        }
    }

    /**
     * @description: Ham thuc hien qua trinh xoa Document
     * @param:
     * @return:
     */
    void doDeleteDoc() {
        Scanner sc = new Scanner(System.in);
        // menu
        System.out.println("----------Delete Document---------");
        System.out.print("Enter ID of Document: ");
        try {
            // Nhap Id Document can xoa
            int id = sc.nextInt();
            if (delDocFromSet(new Document(id))) System.out.println("Done!");
            else System.out.println("Not found the document with id " + id);
        } catch (Exception e) {
            System.out.println("Invalid ID");
        }
        return;
    }

    /**
     * @description: Hien thi tat cac cac Document hien co
     * @param:
     * @return:
     */
    void showAllDoc() {
        if (documentSet.isEmpty()) System.out.println("No document");
        else documentSet.forEach(System.out::println);
    }

    /**
     * @description: ham thuc hien qua trinh tim kiem cac Document theo tung type rieng
     * @param:
     * @return: So Document thuoc type tim duoc
     */
    int doFindDoc() {
        int typeOfDoc = -1;
        AtomicInteger number = new AtomicInteger();
        Scanner sc = new Scanner(System.in);
        while (true) {
            //menu
            System.out.println("--------Find Document by Type ---------");
            for (TypeOfDocument type : TypeOfDocument.values()) {
                System.out.println("Enter " + type.getNumOfType() + " to find " + type);
            }
            System.out.println("Enter 0 to Back");
            try {
                // Nhap kieu Document can tim
                typeOfDoc = sc.nextInt();
                if (typeOfDoc == 0) return -1;
                if (typeOfDoc < 0 || typeOfDoc > MAXTYPE) throw new InputMismatchException("Invalid");
                //Tim kiem
                int typ = typeOfDoc;
                documentSet.parallelStream().filter(d -> d.getNumType() == typ).forEach(d -> {
                    System.out.println(d);
                    number.getAndIncrement();
                });
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("Total found: " + number.get());
            return number.get();
        }
    }
}
