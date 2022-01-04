package Bai4;

/**
 * Class quan ly khu pho, chua cac method them moi n ho dan, hien thi thong tin
 */
public class Manager {

    /**
     * @description: Them moi n ho gia dinh vao doi tuong town
     * @param: Town town, (so luong ho can them) int numOfFamily
     * @return: true neu thanh cong them duoc it nhat 1 Family
     */
    public boolean addFamilytoTown(Town town, int numOfFamily) {
        if (numOfFamily <= 0) {
            System.out.println("So luong ho phai >=1");
            return false;
        }
        System.out.println("--------Them cac ho gia dinh vao thanh pho ---------");
        System.out.println("So luong ho hien tai: " + town.getTotalFamily());
        System.out.println("So luong nguoi sinh song: " + town.getTotalPerson());
        System.out.println("So luong ho can them vao: " + numOfFamily);
        boolean checkAddDone = false;
        for (int i = 1; i <= numOfFamily; i++) {
            System.out.println("ADD Ho thu : " + i);
            if (town.addNewFamily() == 1) {
                System.out.println("*** Da them gia dinh thu " + i);
            } else System.out.println("*** Gia dinh thu " + i + " them KHONG thanh cong");
        }
        return checkAddDone;
    }

    /**
     * @description: Hien thi thong tin thanh pho
     * @param:
     * @return:
     */
    public void showTownInfo(Town town) {
        System.out.println(town);
    }

}
