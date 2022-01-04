package Bai6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Class School: chua danh sach hoc sinh, method them hoc sinh, hien thi thong tin, tim kiem theo dieu kien
 */
public class School {
    private List<Student> studentList;// list student

    public School() {
        this.studentList = new ArrayList<>();
    }

    /**
     *@description: Them hoc sinh vao list
     *@param: student obj
     *@return:
     */
    public void add(Student student) {
        this.studentList.add(student);
    }

    /**
     *@description: Them mot hoc sinh moi voi du lieu nhap tu ban phim vao list
     *@param:
     *@return:
     */
    public void addnewStudent() {
        Scanner sc = new Scanner(System.in);
        //menu va nhap du lieu
        System.out.println("------- Them moi hoc sinh -------");
        try {
            // Nhap du lieu
            System.out.print("Nhap Lop: ");
            String classSudent = sc.nextLine().toUpperCase();
            System.out.print("Nhap Ho va ten: ");
            String name = sc.nextLine();
            System.out.print("Nhap tuoi: ");
            int age = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap que quan: ");
            String homeTown = sc.nextLine();
            // add student moi vao list
            studentList.add(new Student(name, age, homeTown, classSudent));
            System.out.println("Them moi hoc sinh thanh cong");
            // hien thi ket qua
        } catch (Exception e) {
            System.out.println("Gia tri nhap khong hop le");
            return;
        }
    }

    /**
     *@description: Hien thi thong tin tat ca hoc sinh
     *@param:
     *@return:
     */
    void showAllStudentInfo() {
        studentList.forEach(System.out::println);
    }

    /**
     *@description: Loc hoc sinh theo tuoi
     *@param: int age
     *@return: Stream<Student> cac hoc sinh co tuoi = age
     */
    public Stream<Student> filterByAge(int age) {
        return studentList.stream().filter(s -> s.getAge() == age);
    }

    /**
     *@description: Loc hoc sinh co que quan homeTown cua Stream
     *@param: Stream<student> obj, String homeTown
     *@return: long: so luong hoc sinh thoa man
     */
    public long filterWithHomeTown(Stream<Student> studentStream, String homeTown) {
        return studentStream.filter(s -> s.getHomeTown().equalsIgnoreCase(homeTown)).count();
    }
}
