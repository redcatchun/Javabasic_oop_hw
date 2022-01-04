package Bai7;

/**
 * Class giao vien
 */
public class Teacher {
    private double salary; //luong cung
    private double bonus; //luong thuong
    private double penalty; //luong phat
    private double realSalary; //luong thuc te
    private String name;
    private int age;
    private String hometown;
    private int id;// ma so giao vien

    public Teacher(int id, String name, int age, String hometown, double salary, double bonus, double penalty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hometown = hometown;
        this.salary = salary > 0 ? salary : 0;
        this.bonus = bonus > 0 ? bonus : 0;
        this.penalty = penalty > 0 ? penalty : 0;
        this.realSalary = salary + bonus - penalty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getRealSalary() {
        return realSalary;
    }

    @Override
    public String toString() {
        return "Giao vien: " + name +
                ", id: " + id +
                ", age " + age +
                ", que quan: " + hometown +
                ", luong cung: " + salary +
                ", thuong: " + bonus +
                ", phat: " + penalty +
                ", thuc te = " + realSalary;
    }
}
