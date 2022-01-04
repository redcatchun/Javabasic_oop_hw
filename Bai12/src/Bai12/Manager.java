package Bai12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Manager {
    private HashMap<String, Vehicle> vehicleMap;

    public Manager() {
        vehicleMap = new HashMap();
        // du lieu de test
        vehicleMap.put("100", new Truck("100", "aa", 1999, 1253, "red", 1500));
    }

    /**
     *@description: Kiem tra id va tra ve obj vehicle
     *@param: 
     *@return: null neu khong co
     */
    public Vehicle checkVehicleId(String id) {
        return vehicleMap.get(id);
    }

    /**
     *@description: Tao vehicle theo cac type 1 2 3
     *@param: type , vehicle data
     *@return: vehicle obj / null
     */
    public Vehicle creatVehicleOfType(int type, String[] vehicleData) {
        switch (type) {
            case 1:
                return new Car(vehicleData);
            case 2:
                return new Motorcycle(vehicleData);
            case 3:
                return new Truck(vehicleData);
            default:
                return null;
        }
    }

    /**
     *@description: Menu nhap du lieu can thiet
     *@param: 
     *@return: array string chua cac du lieu/null neu nhap sai cu ohap
     */
    public String[] creatData(int type, String id) {
        for (VehicleType typeVehicle : VehicleType.values()) {
            if (type == typeVehicle.getTypeNum()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap thong tin phuong tien: " + typeVehicle);
                System.out.print("Nhap mau xe: ");
                String color = sc.nextLine();
                System.out.print("Nhap Hang san xuat: ");
                String manufacturer = sc.nextLine();
                System.out.print("Nhap nam san xuat: ");
                String yearManufacturer = sc.nextLine();
                System.out.print("Nhap gia: ");
                String price = sc.nextLine();
                String speAtt1 = "";
                String speAtt2 = "";
                System.out.print("Nhap " + typeVehicle.getSpeacialAtt1() + ": ");
                speAtt1 = sc.nextLine();
                if (typeVehicle.getSpeacialAtt2() != "") {
                    System.out.print("Nhap " + typeVehicle.getSpeacialAtt2() + ": ");
                    speAtt2 = sc.nextLine();
                }
                return new String[]{id, manufacturer, yearManufacturer, price, color, speAtt1, speAtt2};
            }
        }
        return null;
    }

    /**
     *@description: Them moi 1 phuong tien co kieu type, id duoc nhap
     *@param: id,tupe
     *@return: -1 Neu gia tri nhap khong hop le/ 0 neu id da ton tai / 1 neu thanh cong
     */
    public int addNewVehical(String id, int typeSelect) {
        if (checkVehicleId(id) != null) {
            System.out.println("Id da ton tai, chon id khac");
            return 0;
        }
        try {
            Vehicle newVehicle = creatVehicleOfType(typeSelect, creatData(typeSelect, id));
            vehicleMap.put(id, newVehicle);
            System.out.println("Tao moi thanh cong");
            return 1;
        } catch (Exception e) {
            System.out.println("Gia tri nhap khong hop le");
            return -1;
        }
    }

    /**
     *@description: Xoa phuong tien theo id
     *@param: 
     *@return: true - thanh cong / flase - that bai
     */
    public boolean deleteById(String id) {
        Vehicle rmObj = vehicleMap.remove(id);
        if (rmObj != null) {
            System.out.println("- Xoa thanh cong: " + rmObj);
            return true;
        } else {
            System.out.println("- Khong ton tai phuong tien co id " + id);
            return false;
        }
    }

    /**
     *@description: Tim kiem phuong tien theo nha san xuat va mau sac
     *@param: 
     *@return: 
     */
    public int searchVehicleBy(String manufacturer, String color) {
        System.out.println(manufacturer);
        System.out.println(color);
        List<Vehicle> foundList = vehicleMap.values().stream().
                filter(ve -> {
                    int check1 = ve.getManufacturer().compareToIgnoreCase(manufacturer);
                    int check2 = ve.getColor().compareToIgnoreCase(color);
                    return check1 == 0 && check2 == 0;
                }).collect(Collectors.toList());
        if (foundList.size() > 0) {
            foundList.forEach(System.out::println);
            return foundList.size();
        } else {
            System.out.println("khong tim thay phuong tien phu hop");
            return 0;
        }
    }
}
