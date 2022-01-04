package bai1;

public class Worker extends Officer {
    public Worker(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level < 0 ? 0 : level;
        this.level = level > 10 ? 10 : level;
    }

    private int level;// bac tu 1-10

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Dinh nghia lai method toString() cua class
    @Override
    public String toString() {
        return "Worker {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                '}';
    }
}
