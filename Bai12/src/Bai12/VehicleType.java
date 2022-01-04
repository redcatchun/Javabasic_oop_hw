package Bai12;

public enum VehicleType {
    CAR(1, "So cho ngoi", "Kieu dong co"),
    MOTORCYCLE(2, "Cong suat", ""),
    TRUCK(3, "Trong tai", "");

    private int typeNum;
    private String speacialAtt1;
    private String speacialAtt2;

    VehicleType(int typeNum, String speacialAtt1, String speacialAtt2) {
        this.typeNum = typeNum;
        this.speacialAtt1 = speacialAtt1;
        this.speacialAtt2 = speacialAtt2;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public String getSpeacialAtt1() {
        return speacialAtt1;
    }

    public String getSpeacialAtt2() {
        return speacialAtt2;
    }

}
