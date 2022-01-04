package Bai9;

/**
 * Class Cong to dien
 */
public class ElecticMeter {
    private int meterCode;// Ma so cong to dien
    private Customer customer;//Khach hang
    private int oldParameter;//So dien cu
    private int newParameter;//So dien moi

    public ElecticMeter(int meterCode) {
        // Cai dat tham so mac dinh de test
        this.meterCode = meterCode;
        this.customer = null;
        this.oldParameter = 0;
        this.newParameter = 10;
    }

    public ElecticMeter(int meterCode, Customer customer, int oldParameter, int newParameter) {
        this.meterCode = meterCode;
        this.customer = customer;
        this.oldParameter = oldParameter;
        this.newParameter = newParameter;
    }

    /**
     *@description: Reset ve trang thai khong co nguoi thue, chi so moi = cu
     *@param: 
     *@return: 
     */
    public void reset() {
        this.customer = null;
        this.oldParameter = this.newParameter;
    }

    /**
     *@description: Tinh toan so tien dien phai tra, update so dien cu = so dien hien tai
     *@param: 
     *@return: 
     */
    public double getCost() {
        double money = (newParameter - oldParameter) * 5;
        this.oldParameter = this.newParameter;
        return money;
    }
    
    public int getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(int meterCode) {
        this.meterCode = meterCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ElecticMeter setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public int getOldParameter() {
        return oldParameter;
    }

    public void setOldParameter(int oldParameter) {
        this.oldParameter = oldParameter;
    }

    public int getNewParameter() {
        return newParameter;
    }

    public void setNewParameter(int newParameter) {
        this.newParameter = newParameter;
    }

    @Override
    public String toString() {
        return "Cong to dien: " + meterCode +
                "\n - " + customer +
                "\n - So cong to cu = " + oldParameter +
                ", so cong to moi = " + newParameter;
    }
}
