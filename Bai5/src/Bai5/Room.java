package Bai5;

/**
 * Class Room: chua cac thuoc tinh, method tinh tien va reset
 */
public class Room {
    protected int roomNum;// so phong
    protected long personID;// ID nguoi dang thua
    protected int rentalTime;// Thoi gian thue
    protected static int price;// Gia phong

    public Room() {
        personID = -1;// mac dinh khong co nguoi thue
        rentalTime = 0;// mac dinh
    }

    /**
     * @description: Thue phong theo id
     * @param: id, thoi gian thue
     * @return:
     */
    public void hireByID(long idCard, int rentalTime) {
        this.personID = idCard;
        this.rentalTime = rentalTime;
    }

    /**
     * @description: reset phong ve trang thai khong co nguoi thue
     * @param:
     * @return:
     */
    public void reset() {
        personID = -1;
        rentalTime = 0;
    }

    /**
     * @description: Tinh tien
     * @param:
     * @return: so tien phai tra
     */
    int getCost() {
        return price * rentalTime;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Room.price = price;
    }
}
