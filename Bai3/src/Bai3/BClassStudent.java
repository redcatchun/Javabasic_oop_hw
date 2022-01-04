package Bai3;

// Class thi sinh khoi B
public class BClassStudent extends Student {
    public BClassStudent(int id, String name, String adress, int priority) {
        super(id, name, adress, priority);
        this.subjects = new String[]{"Toan", "Hoa", "Sinh"};
        this.type = "B";
    }
}
