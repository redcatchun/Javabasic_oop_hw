package bai1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Manager {
    // List officer
    private List<Officer> officerList;
    // So loai officer (woker, enginner, staff) = 3
    static final int MAXTYPE = 3;

    public Manager() {
        officerList = new ArrayList<Officer>();
    }

    /**
     * @description: them officer vao listofficer
     * @param: Officer officer
     * @return:
     */
    public void addOfficer(Officer officer) {
        officerList.add(officer);
    }

    /**
     * @description: Tim danh sach cac officer co cung ten
     * @param: String name
     * @return: So luong officer trung ten
     */
    public int searchByName(String name) {
        List<Officer> searchList = officerList.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toList());
        searchList.forEach(System.out::println);
        return searchList.size();
    }

    /**
     * @description: Hien thi info cua list officer
     * @param: List offficerList hoac khong
     * @return:
     */
    public void showListInfo() {
        this.officerList.forEach(System.out::println);
    }

    public void showListInfo(List officerList) {
        Optional.ofNullable(officerList).ifPresent(o -> o.forEach(System.out::println));
    }

    /**
     * @description: tao moi mot doi tuong officer
     * @param: int type(Dai dien cho kieu officer)
     * @return: officer - thanh cong / null - that bai
     */
    public static Officer creatOfficer(int type) {
        Scanner scanner = new Scanner(System.in);
        // Duyet Enum, kiem tra type de xac nhan kieu officer (woker/enginner/staff...)
        for (TypeOfOfficer job : TypeOfOfficer.values()) {
            if (type == job.getNumberOfJob()) {
                // Da xac nhan duoc kieu officer
                try {
                    //Nhap thong tin
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (name == "") throw new Exception();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter gender: ");
                    scanner.nextLine();
                    String gender = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter " + job.getSpecialAttribute() + ":");
                    String sA = scanner.nextLine();
                    if (sA == "") throw new Exception();
                    // tao moi doi tuong Officer
                    switch (type) {
                        case 1:
                            return new Worker(name, age, gender, address, Integer.parseInt(sA));
                        case 2:
                            return new Engineer(name, age, gender, address, sA);
                        case 3:
                            return new Staff(name, age, gender, address, sA);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid information");
                    break;
                }
            }
        }
        // Tra ve null neu tao that bai
        return null;
    }

    /**
     * @description: ham qua trinh them Officer moi
     * @param:
     * @return:
     */
    public void doInsertOfficer() {
        // Loai officer
        int typeSelect;
        while (true) {
            // Menu lua chon loai officer can them, lay du lieu tu Enum: TypeOfOfficer
            // VD:(Menu) Enter 1: Insert a WORKER
            System.out.println("----------Insert Officer ----------");
            for (TypeOfOfficer job : TypeOfOfficer.values()) {
                System.out.println("Enter " + job.getNumberOfJob() + ": Insert a " + job);
            }
            System.out.println("...................................");
            System.out.println("Enter 0: Back");
            Scanner scanner = new Scanner(System.in);
            try {
                typeSelect = scanner.nextInt();
                // Kiem tra tinh hop le
                if (typeSelect == 0) return;
                if (typeSelect > 0 && typeSelect <= MAXTYPE) {
                    // Tao newOfficer ung voi type select
                    Officer newOfficer = creatOfficer(typeSelect);
                    // Kiem tra null
                    Optional.ofNullable(newOfficer).ifPresent(n -> addOfficer(n));
                    break;
                } else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                // Nhap gia tri khong hop le
                System.out.println("Invalid");
            }
        }
    }
}
