package bai1;

public class Staff extends Officer {
    public Staff(String name, int age, String gender, String address, String task) {
        super(name, age, gender, address);
        this.task = task;
    }

    private String task;// Cong viec

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    // Dinh nghia lai method toString() cua class
    @Override
    public String toString() {
        return "Staff {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
