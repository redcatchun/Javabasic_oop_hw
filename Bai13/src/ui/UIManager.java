package ui;

import entity.*;
import exception.*;
import service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UIManager {
    private EmployeeManager employeeManager;

    public UIManager() {
        employeeManager = new EmployeeManager();
    }

    /**
     *@description: Them hoac cap nhap nhan vien
     *@param: them moi = 1, cap nhap = 0
     *@return: true/false
     */
    public boolean insertEmployee(int newOrUpdate) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap 1: Chon Experience");
            System.out.println("Nhap 2: Chon Fresher");
            System.out.println("Nhap 3: Chon Intern");
            System.out.println("Nhap 0: Quay lai");
            String type = sc.nextLine();
            Employee employee = null;
            try {
                switch (type) {
                    case "1": {
                        employee = creatExperience(newOrUpdate);
                        break;
                    }
                    case "2": {
                        employee = creatFresher(newOrUpdate);
                        break;
                    }
                    case "3": {
                        employee = creatIntern(newOrUpdate);
                        break;
                    }
                    case "0":
                        return false;
                    default:
                        System.out.println("Khong hop le");
                }
                if (employee == null) {
                    System.out.println("That bai");
                    return false;
                }
                // kiem tra cac thong tin co hop le hay chua
                checkData(employee);
                // sau khi hop le thi add vao list
                this.employeeManager.addEmployee(employee);
                System.out.println("Thanh cong");
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     *@description: tao thong tin co ban cua moi employee
     *@param: Tao moi = 1, cap nhap = 0
     *@return: String data
     */
    private String[] setDataBasic(int newOrUpdate) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();
        if (newOrUpdate == 1 && employeeManager.findById(id) != null) return null;
        System.out.print("Nhap Ho va ten: ");
        String fullname = sc.nextLine();
        System.out.print("Nhap ngay sinh:");
        String date = QScanner.stringDate();
        if (date == null) return null;
        System.out.print("Nhap SDT: ");
        String phone = sc.nextLine();
        System.out.print("Nhap Email: ");
        String email = sc.nextLine();
        return new String[]{id, fullname, date, phone, email};
    }

    /**
     *@description: Tao doi tuong Experience
     *@param:
     *@return:
     */
    private Experience creatExperience(int newOrUpdate) {
        String[] basicData = setDataBasic(newOrUpdate);
        Scanner sc = new Scanner(System.in);
        if (basicData != null) {
            System.out.print("Nhap nam kinh ngiem: ");
            int yearOfExperience = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap Ky nang chuyen mon: ");
            String proSkill = sc.nextLine();
            return new Experience(basicData, yearOfExperience, proSkill);
        } else return null;
    }

    /**
     *@description: Tao doi tuong Fresher
     *@param:
     *@return:
     */
    private Fresher creatFresher(int newOrUpdate) {
        String[] basicData = setDataBasic(newOrUpdate);
        Scanner sc = new Scanner(System.in);
        if (basicData != null) {
            System.out.print("Nhap thoi gian tot nghiep: ");
            LocalDate graduationDate = QScanner.localDate();
            if (graduationDate == null) return null;
            System.out.print("Nhap xep loai tot nghiep: ");
            String graduationRank = sc.nextLine();
            System.out.print("Nhap truong tot nghiep: ");
            String universityName = sc.nextLine();
            return new Fresher(basicData, graduationDate, graduationRank, universityName);
        } else return null;
    }

    /**
     *@description: Tao doi tuong Intern
     *@param:
     *@return:
     */
    private Intern creatIntern(int newOrUpdate) {
        String[] basicData = setDataBasic(newOrUpdate);
        Scanner sc = new Scanner(System.in);
        if (basicData != null) {
            System.out.print("Nhap Chuyen nganh: ");
            String major = sc.nextLine();
            System.out.print("Nhap hoc ky: ");
            int semester = Integer.parseUnsignedInt(sc.nextLine());
            System.out.print("Nhap truong dang theo hoc: ");
            String universityName = sc.nextLine();
            return new Intern(basicData, major, semester, universityName);
        } else return null;
    }

    private final int UPDATE = 0;

    /**
     *@description: Update thong tin nhan vien
     *@param:
     *@return:
     */
    public void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID nhan vien muon cap nhap: ");
        String id = sc.nextLine();
        Employee oldEmployee = this.employeeManager.findById(id);
        if (oldEmployee == null) {
            System.out.println("Khong ton tai nhan vien co ID tren");
            return;
        }
        // Goi ham ínsertEmployee voi tham so la UPDATE, neu tra ve true xoa employee cu khoi list
        if (insertEmployee(UPDATE)) employeeManager.deleteById(id);
    }

    /**
     *@description: Nhap id, xoa employee
     *@param:
     *@return:
     */
    public void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID nhan vien muon xoa: ");
        String id = sc.nextLine();
        if (employeeManager.deleteById(id)) System.out.println("Xoa thanh cong");
        else System.out.println("Khong ton tai nhan vien co ID tren");
    }

    /**
     *@description: Hien thi cac kieu nhan vien
     *@param:
     *@return:
     */
    public void showTypeEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap 1 xem danh sach Experience");
        System.out.println("Nhap 2 xem danh sach Fresher");
        System.out.println("Nhap 3 xem danh sach Intern");
        System.out.println("Nhap 0 Quay lai");
        int type = Integer.parseUnsignedInt(sc.nextLine());
        if (type > 0 && type < 4) {
            List<Employee> list = employeeManager.findByType(type);
            if (list.isEmpty()) {
                System.out.println("Danh sach trong");
            } else list.forEach(System.out::println);
        } else System.out.println("Khong hop le");
    }

    //Show all thong tin
    public void showAllEmployee() {
        this.employeeManager.findAll().forEach(Employee::showMe);
    }

    /**
     *@description: Kiem tra thong tin cua employee co phu hop hay khong
     *@param:
     *@return:
     */
    private void checkData(Employee employee) throws
            BirthDayException, PhoneException, EmailException, FullNameException {
        ValidatorService.birthdayCheck(employee.getBirthday());
        ValidatorService.phoneCheck(employee.getPhone());
        ValidatorService.emailCheck(employee.getEmail());
        ValidatorService.nameCheck(employee.getFullName());
    }
}
