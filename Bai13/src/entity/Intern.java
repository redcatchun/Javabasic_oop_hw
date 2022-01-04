package entity;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee {
    private String major;
    private int semester;
    private String universityName;

    public Intern(String[] data, String major, int semester, String universityName) {
        super(data);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(String id, String fullName, LocalDate birthday, String phone, String email, List<Certificate> certificates, String major, int semester, String universityName) {
        super(id, fullName, birthday, phone, email, certificates);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void showMe() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Intern{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                ", major='" + major + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
