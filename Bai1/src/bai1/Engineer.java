package bai1;

// class ky su ke thua tu class can bo
public class Engineer extends Officer {
    public Engineer(String name, int age, String gender, String address, String branch) {
        super(name, age, gender, address);
        this.branch = branch;
    }

    private String branch;// Nganh dao tao

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    // Dinh nghia lai method toString() cua class
    @Override
    public String toString() {
        return "Engineer {" +
                "branch='" + branch + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

