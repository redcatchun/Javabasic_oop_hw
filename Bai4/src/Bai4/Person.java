package Bai4;

/**
 * Class nguoi dan
 */
public class Person {
    // Thuoc tinh rieng: Ten, tuoi, cong viec, CMND
    private String name;
    private int age;
    private String job;
    private long idCard;

    public Person(String name,int age,String job, long idCard){
        this.name=name;
        this.age=age;
        this.job=job;
        this.idCard=idCard;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", age=" + age +
                ", job=" + job +
                ", idCard=" + idCard;
    }
}
