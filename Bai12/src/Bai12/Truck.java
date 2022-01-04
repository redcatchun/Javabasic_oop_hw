package Bai12;

public class Truck extends Vehicle{
    private int tonnage;

    public Truck(String id, String manufacturer, int yearOfManufacture, int price, String color, int tonnage) {
        super(id, manufacturer, yearOfManufacture, price, color);
        this.tonnage = tonnage;
    }
    public Truck(String[] arrInfo){
        super(arrInfo);
        this.tonnage=Integer.parseUnsignedInt(arrInfo[5]);
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }
}
