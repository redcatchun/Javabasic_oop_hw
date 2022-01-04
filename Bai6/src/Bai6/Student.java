package Bai6;

/**
 * Class Student
 */
public class Student {
    private String classStudent;//lop
    private String name;//Ten
    private int age;//Tuoi
    private String homeTown;


    public Student(String name, int age, String homeTown, String classStudent) {
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
        this.classStudent = classStudent;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
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

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "Hoc sinh: " + name +
                ", lop: " + classStudent +
                ", tuoi: " + age +
                ", que quan: " + homeTown;
    }

}
