package Bai9;

/**
 * Class Khach hang
 */
public class Customer {
    private String hostName;//Chu ho
    private String address;// Dia chi
    private int meterCode;// Ma so cong to dien

    public Customer(String hostName, String address, int meterCode) {
        this.hostName = hostName;
        this.address = address;
        this.meterCode = meterCode;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(int meterCode) {
        this.meterCode = meterCode;
    }


    @Override
    public String toString() {
        return "Khach hang: " + hostName +
                ", Ma cong to dien: " + meterCode +
                ", Dia chi: " + address;
    }
}
