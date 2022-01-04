package Bai8;

/**
 * Class Sinh vien
 */
public class Student {
    private String name;
    private int age;
    private String classRoom;

    public Student(String name, int age, String classRoom) {
        this.name = name;
        this.age = age;
        this.classRoom = classRoom;
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

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Sinh vien: " + name +
                ", Tuoi: " + age +
                ", Lop: " + classRoom;
    }
}
