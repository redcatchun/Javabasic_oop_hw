package Bai3;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Manager {
    // Cac khoi thi
    static String[] types = {"A", "B", "C"};
    // set Student
    Set<Student> studentSet;

    public Manager() {
        studentSet = new HashSet<>();
    }
    /**
     *@description: Thuc hien qua trinh them moi student
     *@param: 
     *@return:
     */
    void doInsert() {
        Scanner sc = new Scanner(System.in);
        boolean checkDone = false;// bien kiem tra xem them moi co ok ko

        //menu va nhap du lieu
        System.out.println("------- Them moi thi sinh -------");
        try {
            System.out.print("Nhap ID : ");
            int id = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap Ho va ten: ");
            String name = sc.nextLine();
            System.out.print("Nhap dia chi: ");
            String address = sc.nextLine();
            System.out.print("Nhap muc uu tien: ");
            int priority = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap khoi thi cua thi sinh: ");
            String type = sc.nextLine().toUpperCase();
            // add student moi vao set
            switch (type) {
                case "A": {
                    checkDone = studentSet.add(new AClassStudent(id, name, address, priority));
                    break;
                }
                case "B": {
                    checkDone = studentSet.add(new BClassStudent(id, name, address, priority));
                    break;
                }
                case "C": {
                    checkDone = studentSet.add(new CClassStudent(id, name, address, priority));
                    break;
                }
                default:
                    throw new Exception();
            }
            // hien thi ket qua
        } catch (Exception e) {
            System.out.println("Gia tri nhap khong hop le");
            return;
        }
        if (checkDone) System.out.println("Them thanh cong");
        else System.out.println("Loi trung ID");
    }

/**
 *@description: hien thi tat cac cac student
 *@param:
 *@return:
 */
    void showAllInfo(){
        if(studentSet.isEmpty()) System.out.println("Danh sach trong");
        else studentSet.forEach(System.out::println);
    }

    /**
     *@description: Tim kiem student theo ID
     *@param:
     *@return:
     */
    void findById(){
        Scanner sc = new Scanner(System.in);
        int id;
        // Nhap thong tin
        System.out.println("-------Tim thi sinh theo ID-------");
        System.out.print("Nhap ID thi sinh can tim: ");
        try{
            id = Integer.parseUnsignedInt(sc.nextLine());

        }catch (InputMismatchException e){
            System.out.println("Yeu cau nhap dung ID");
            return;
        }
        // Kiem tra student nao co trung id trong set
        for(Student s:studentSet){
            if(s.getId()==id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Khong co thi sinh nao co ID "+id);
    }

}
