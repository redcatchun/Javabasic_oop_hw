package Bai12;

public class Car extends Vehicle {
    private int numberSeats;
    private String engineType;

    public Car(String id, String manufacturer, int yearOfManufacture, int price, String color, int numberSeats, String engineType) {
        super(id, manufacturer, yearOfManufacture, price, color);
        this.numberSeats = numberSeats;
        this.engineType = engineType;
    }

    public Car(String[] arrInfo) {
        super(arrInfo);
        this.numberSeats = Integer.parseUnsignedInt(arrInfo[5]);
        this.engineType = arrInfo[6];
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
