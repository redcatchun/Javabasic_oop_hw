package Bai9;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

/**
 * Quan ly cong to dien: methos them, xoa,chinh sua khach hang theo ma cong to,
 * hien thi cac cong to san su dung
 */
public class Manager {
    HashMap<Integer, Customer> idCustomerMap;// map noi meterCode - customer
    HashMap<Integer, ElecticMeter> idMeterMap;//map noi meterCode - meter

    public Manager() {
        idMeterMap = new HashMap<>(200);
        idCustomerMap = new HashMap<>(200);
    }

    /**
     *@description: Tao moi dong ho theo ma so cong to moi
     *@param: int newmeterCode
     *@return: ElectricMeter obj hoac null
     */
    public ElecticMeter creatNewMeter(int newMeterCode) {
        System.out.println("---------Tao moi cong to --------");
        if (newMeterCode > 0) {
            ElecticMeter newMeter = new ElecticMeter(newMeterCode);
            //idMeterMap.put(newMeterCode,newMeter);
            return newMeter;
        } else {
            System.out.println("Khong hop le");
            return null;
        }
    }
    
    /**
     *@description: Them moi mot khach hang
     *@param: 
     *@return: 
     */
    public void addNewCustomer() {
        System.out.println("----------- Tao moi khach hang----------");
        // Goi ham update voi mode NEWDATA
        updateCustomer(NEWDATA, 0);
    }

    private final int EDITDATA = 1;
    private final int NEWDATA = 0;

    /**
     *@description: Ham update du lieu khach hang tu ban phim
     *@param: int mode(EDIT/NEWDATA),int oldMeterCode
     *@return: Customer duoc update
     */
    private Customer updateCustomer(int mode, int oldMeterCode) {
        Scanner sc = new Scanner(System.in);
        String doWhat = mode == NEWDATA ? "Tao moi" : "Sua thong tin";
        // Nhap du lieu
        if (mode == EDITDATA) System.out.println("Ma so cong to dien cu: " + oldMeterCode);
        System.out.print("Nhap ten chu ho moi: ");
        String hostName = sc.nextLine();
        System.out.print("Nhap dia chi moi: ");
        String address = sc.nextLine();
        System.out.print("Nhap ma cong to dien moi: ");
        try {
            int newMeterCode = Integer.parseUnsignedInt(sc.nextLine());
            if (oldMeterCode == newMeterCode || idCustomerMap.get(newMeterCode) == null) {
                // TH khong co khach hang nao su dung cong to nay hoac chinh sua khong thay doi cong to
                //Tao moi customer va newMeter theo gia tri da nhap
                Customer newCustomer = new Customer(hostName, address, newMeterCode);
                ElecticMeter newMeter = creatNewMeter(newMeterCode).setCustomer(newCustomer);
                if (mode == EDITDATA) {//Truong hop chinh sua
                    if (oldMeterCode == newMeterCode) // MeterCode khong thay doi
                        // Set newMeterCode = oldMeterCode va update lai khach hang
                        newMeter = idMeterMap.get(oldMeterCode).setCustomer(newCustomer);
                    else {// Thay doi meterCode
                        idCustomerMap.remove(oldMeterCode);// Xoa lien ket map cu giua id va Customer
                        idMeterMap.get(oldMeterCode).reset();// Reset du lieu tren meter
                    }
                } 
                /// Cap nhap du lieu
                idCustomerMap.put(newMeterCode, newCustomer);
                idMeterMap.put(newMeterCode, newMeter);
                System.out.println(doWhat + " khach hang thanh cong");
                return newCustomer;
            } else throw new Exception();
        } catch (Exception e) {
            System.out.println(doWhat + " khach hang KHONG thanh cong");
            return null;
        }
    }

    /**
     *@description: Chinh sua cutomer
     *@param: 
     *@return: 
     */
    public void editCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Chinh sua thong tin khach hang ----------");
        System.out.print("Nhap ma so cong to ho khach can chinh sua: ");
        try {
            int oldMeterCode = Integer.parseUnsignedInt(sc.nextLine());
            if (idCustomerMap.containsKey(oldMeterCode)) //neu meter con chinh sua co ton tai va duoc su dung
                updateCustomer(EDITDATA, oldMeterCode);
            else System.out.println("Cong to tren khong co khach su dung");
        } catch (NumberFormatException e) {
            System.out.println("Khong hop le");
        }
    }
    
    /**
     *@description: Xoa Customer theo Customer
     *@param: 
     *@return: 
     */
    public boolean deleteCustomer(Customer customer) {
        return Optional.ofNullable(idCustomerMap.remove(customer.getMeterCode())).isPresent();
    }

    /**
     *@description: Xoa Customer tu ma meterCode nhap tu ban phim
     *@param: 
     *@return: 
     */
    public boolean deleteCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Xoa khach hang ----------");
        System.out.print("Nhap ma so cong to ho khach can xoa: ");
        try {
            int meterCode = Integer.parseUnsignedInt(sc.nextLine());
            // Xoa Customer
            Customer delCus = idCustomerMap.remove(meterCode);
            if (delCus != null) {
                // Xoa thanh cong, reset lai thong tin dong ho tuong ung
                idMeterMap.get(meterCode).reset();
                System.out.println(delCus + "\n*** Da xoa ****");
                return true;
            } else {
                System.out.println("Cong to tren khong co khach su dung");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Khong hop le");
            return false;
        }
    }

    /**
     *@description: Kiem tra so tien can thanh toan
     *@param: 
     *@return: 
     */
    public void getBill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Tinh tien dien ----------");
        System.out.print("Nhap ma so cong to ho khach can thanh toan: ");
        try {
            int meterCode = Integer.parseUnsignedInt(sc.nextLine());
            if (idCustomerMap.containsKey(meterCode))//Neu Meter dang duoc su dung?
                System.out.println("So tien phai tra: " + idMeterMap.get(meterCode).getCost());
            else System.out.println("Cong to tren khong co khach su dung");
        } catch (NumberFormatException e) {
            System.out.println("Khong hop le");
        }
    }

    /**
     *@description: Hien thi thong tin tat ca khach hang
     *@param: 
     *@return: 
     */
    public void showMeterInfo() {
        idCustomerMap.keySet().forEach(id -> System.out.println(idMeterMap.get(id)));
    }

}
