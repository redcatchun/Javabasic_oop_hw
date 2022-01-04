package Bai12;

public class Vehicle {
    protected String id;
    protected String manufacturer;
    protected int yearOfManufacture;
    protected int price;
    protected String color;

    public Vehicle(String id, String manufacturer, int yearOfManufacture, int price, String color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.color = color;
    }

    public Vehicle(String[] vehicleData) {
        if (vehicleData.length < 5) return;
        this.id = vehicleData[0];
        this.manufacturer = vehicleData[1];
        this.yearOfManufacture = Integer.parseUnsignedInt(vehicleData[2]);
        this.price = Integer.parseUnsignedInt(vehicleData[3]);
        this.color = vehicleData[4];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle: " +
                "id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", color='" + color + '\'';
    }
}
