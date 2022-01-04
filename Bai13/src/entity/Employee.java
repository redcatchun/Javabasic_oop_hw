package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static ui.QScanner.fmt;

public abstract class Employee {
    public static long count = 0;
    protected String id;
    protected String fullName;
    protected LocalDate birthday;
    protected String phone;
    protected String email;
    protected List<Certificate> certificates;

    public Employee(String[] infoOfEmployee) {
        this.id = infoOfEmployee[0];
        this.fullName = infoOfEmployee[1];
        this.birthday = LocalDate.parse(infoOfEmployee[2],fmt);
        this.phone = infoOfEmployee[3];
        this.email = infoOfEmployee[4];
        certificates = new ArrayList<>();
    }

    public Employee(String id, String fullName, LocalDate birthday, String phone, String email, List<Certificate> certificates) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.certificates = certificates;
    }

    public abstract void showMe();

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Employee.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
