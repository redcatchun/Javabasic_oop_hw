package Bai12;

public class Motorcycle extends Vehicle {
    private int capacity;
    public Motorcycle(String id, String manufacturer, int yearOfManufacture, int price, String color, int capacity) {
        super(id, manufacturer, yearOfManufacture, price, color);
        this.capacity = capacity;
    }

    public Motorcycle(String[] arrInfo) {
        super(arrInfo);
        this.capacity = Integer.parseUnsignedInt(arrInfo[5]);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
