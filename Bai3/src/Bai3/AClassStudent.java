package Bai3;

// Class thi sinh khoi A
public class AClassStudent extends Student {
    public AClassStudent(int id, String name, String adress, int priority) {
        super(id, name, adress, priority);
        this.subjects = new String[]{"Toan", "Ly", "Hoa"};
        this.type = "A";
    }
}
