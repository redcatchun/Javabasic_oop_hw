package Bai3;

// Class thi sinh khoi C
public class CClassStudent extends Student {
    public CClassStudent(int id, String name, String adress, int priority) {
        super(id, name, adress, priority);
        this.subjects = new String[]{"Van", "Su", "Dia"};
        this.type = "C";
    }
}
